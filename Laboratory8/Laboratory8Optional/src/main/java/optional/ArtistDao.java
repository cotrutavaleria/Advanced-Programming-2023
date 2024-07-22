package optional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao implements Dao<Artist> {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public ArtistDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void create(Artist artist) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO artists (name) VALUES (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Artist> findById(int id) throws SQLException {
        List<Artist> foundAlbums = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                Artist album = new Artist(name);
                album.setId(id);
                foundAlbums.add(album);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAlbums;
    }

    public List<Artist> findByName(String name) throws SQLException {
        List<Artist> foundArtists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists WHERE name = '" + name + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Artist album = new Artist(name);
                album.setId(id);
                foundArtists.add(album);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundArtists;
    }

    public List<Artist> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(
                     "SELECT * FROM artists")) {
            List<Artist> foundArtists = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Artist artist = new Artist(name);
                artist.setId(id);
                foundArtists.add(artist);
            }
            if (!foundArtists.isEmpty()) {
                return foundArtists;
            } else {
                throw new SQLException("There are no artist in the database.");
            }
        }
    }


}

