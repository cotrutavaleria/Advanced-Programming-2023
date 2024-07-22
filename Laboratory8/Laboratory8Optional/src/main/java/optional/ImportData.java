package optional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportData {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public ImportData() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void readFromCsvFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/optional/albumlist.csv"));
            String lineText = null;
            bufferedReader.readLine();
            while ((lineText = bufferedReader.readLine()) != null) {
                List<String> informations = Arrays.asList(lineText.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
                int year = Integer.parseInt(informations.get(1));
                String album = informations.get(2);
                String artist = informations.get(3);
                String genre = informations.get(4);
                String resultedGenre = genre.replaceAll("\"", "");
                String subgenre = informations.get(5);
                this.create(year, album, artist, resultedGenre, subgenre);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(int year, String album, String artist, String genre, String subgenre) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO exported_albums (year, album, artist, genre, subgenre) VALUES (?,?,?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, album);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.setString(5, subgenre);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ImportedAlbum findById(int id) {
        ImportedAlbum importedAlbum = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exported_albums WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int year = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String artist = resultSet.getString(4);
                String genre = resultSet.getString(5);
                String subgenre = resultSet.getString(6);
                importedAlbum = new ImportedAlbum(year, title, artist, genre, subgenre);
                importedAlbum.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return importedAlbum;
    }

    public int getMaxId() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM exported_albums");
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
}
