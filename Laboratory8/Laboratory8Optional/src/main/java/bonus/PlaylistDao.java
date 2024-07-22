package bonus;

import optional.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public PlaylistDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public int getMaxId() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM playlists");
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
    public int getMinId() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MIN(id) FROM playlists");
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public void create(Playlist playlist) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO playlists (name) VALUES (?)")) {
            pstmt.setString(1, playlist.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Playlist> findByName(String name) throws SQLException {
        List<Playlist> foundPlaylists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM playlists WHERE name = '" + name + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String creationStamp = resultSet.getString(3);
                Playlist playlist = new Playlist(name);
                playlist.setId(id);
                playlist.setCreationTimestamp(creationStamp);
                foundPlaylists.add(playlist);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundPlaylists;
    }

    public List<Playlist> findById(int id) throws SQLException {
        List<Playlist> foundPlaylists = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM playlists WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String creationTimestamp = resultSet.getString(2);
                Playlist playlist = new Playlist(name);
                playlist.setId(id);
                playlist.setCreationTimestamp(creationTimestamp);
                foundPlaylists.add(playlist);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundPlaylists;
    }

    public List<Playlist> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM playlists")) {
            List<Playlist> foundPlaylists = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String creationTimestamp = rs.getString(3);
                Playlist playlist = new Playlist(name);
                playlist.setId(id);
                playlist.setCreationTimestamp(creationTimestamp);
                foundPlaylists.add(playlist);
            }
            if (!foundPlaylists.isEmpty()) {
                return foundPlaylists;
            } else {
                return null;
            }
        }
    }
}
