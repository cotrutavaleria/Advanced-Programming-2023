package optional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao implements Dao<Album> {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public AlbumDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void create(Album album) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO albums (release_year, title, artist) VALUES (?,?,?)")) {
            pstmt.setInt(1, album.getYear_release());
            pstmt.setString(2, album.getTitle());
            pstmt.setString(3, album.getArtist());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Album> findByName(String title) throws SQLException {
        List<Album> foundAlbums = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums WHERE title = '" + title + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int year = resultSet.getInt(2);
                String artist = resultSet.getString(4);
                Album album = new Album(year, title, artist);
                album.setId(id);
                foundAlbums.add(album);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAlbums;
    }

    public List<Album> findById(int id) throws SQLException {
        List<Album> foundAlbums = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int year = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String artist = resultSet.getString(4);
                Album album = new Album(year, title, artist);
                album.setId(id);
                foundAlbums.add(album);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAlbums;
    }

    public List<Album> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM albums")) {
            List<Album> foundAlbums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int year = rs.getInt(2);
                String name = rs.getString(3);
                String artist = rs.getString(4);
                Album album = new Album(year, name, artist);
                foundAlbums.add(album);
            }
            if (!foundAlbums.isEmpty()) {
                return foundAlbums;
            } else {
                throw new SQLException("There are no albums in the database.");
            }
        }
    }
}
