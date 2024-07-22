package optional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumGenreDao implements Dao<AlbumGenre> {
    private Connection connection = null;
    private ConnectionPool connectionPool;

    public AlbumGenreDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void create(AlbumGenre albumGenre) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO album_genre (id_album, id_genre) VALUES (?,?)")) {
            pstmt.setInt(1, albumGenre.getAlbumId());
            pstmt.setInt(2, albumGenre.getGenreId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<AlbumGenre> findById(int id) throws SQLException {
        List<AlbumGenre> foundAssociations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM album_genre WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int albumId = resultSet.getInt(2);
                int genreId = resultSet.getInt(3);
                AlbumGenre association = new AlbumGenre(albumId, genreId);
                association.setId(id);
                foundAssociations.add(association);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAssociations;
    }

    public List<AlbumGenre> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM album_genre")) {
            List<AlbumGenre> foundAssociations = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int albumId = rs.getInt(2);
                int genreId = rs.getInt(3);
                AlbumGenre albumGenre = new AlbumGenre(albumId, genreId);
                albumGenre.setId(id);
                foundAssociations.add(albumGenre);
            }
            if (!foundAssociations.isEmpty()) {
                return foundAssociations;
            } else {
                throw new SQLException("There are no association in the database.");
            }
        }
    }

    @Override
    public List<AlbumGenre> findByName(String name) throws SQLException {
        return null;
    }
}
