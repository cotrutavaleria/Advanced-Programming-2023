package bonus;

import optional.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistAlbumsDao {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public PlaylistAlbumsDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void create(PlaylistAlbums playlistAlbums) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO playlists_albums (id_playlist, id_album) VALUES (?,?)")) {
            pstmt.setInt(1, playlistAlbums.getIdPlaylist());
            pstmt.setInt(2, playlistAlbums.getIdAlbum());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<PlaylistAlbums> findByName(String name) throws SQLException {
        return null;
    }

    public List<PlaylistAlbums> findById(int id) throws SQLException {
        List<PlaylistAlbums> foundAssociations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM playlists_albums WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPlaylist = resultSet.getInt(2);
                int idAlbum = resultSet.getInt(3);
                PlaylistAlbums aasociation = new PlaylistAlbums(idPlaylist, idAlbum);
                aasociation.setId(id);
                foundAssociations.add(aasociation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAssociations;
    }
    public List<Integer> findByIdPlaylist(int idPlaylist) throws SQLException {
        List<Integer> albums = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_album FROM playlists_albums WHERE id_playlist = '" + idPlaylist + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idAlbum = resultSet.getInt(1);
                albums.add(idAlbum);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return albums;
    }

    public int findByIdAlbum(int idAlbum) throws SQLException {
        int id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM playlists_albums WHERE id_album = '" + idAlbum + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    public List<PlaylistAlbums> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT  FROM playlists_albums")) {
            List<PlaylistAlbums> foundAssociations = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int idPlaylist = rs.getInt(2);
                int idAlbum = rs.getInt(3);
                PlaylistAlbums association = new PlaylistAlbums(idPlaylist, idAlbum);
                association.setId(id);
                foundAssociations.add(association);
            }
            if (!foundAssociations.isEmpty()) {
                return foundAssociations;
            } else {
                throw new SQLException("There are no associations in the database.");
            }
        }
    }
}
