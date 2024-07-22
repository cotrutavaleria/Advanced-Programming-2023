package optional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDao implements Dao<Genre> {
    private Connection connection = null;
    private ConnectionPool connectionPool;


    public GenreDao() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
    }

    public void create(Genre genre) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO genres (name) VALUES (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Genre> findById(int id) throws SQLException {
        List<Genre> foundGenres = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE id = '" + id + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                Genre genre = new Genre(name);
                genre.setId(id);
                foundGenres.add(genre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundGenres;
    }


    public List<Genre> findByName(String name) throws SQLException {
        List<Genre> foundAlbums = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE name = '" + name + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Genre album = new Genre(name);
                album.setId(id);
                foundAlbums.add(album);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return foundAlbums;
    }


    public List<Genre> getAll() throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM genres")) {
            List<Genre> foundGenres = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Genre genre = new Genre(name);
                genre.setId(id);
                foundGenres.add(genre);
            }
            if (!foundGenres.isEmpty()) {
                return foundGenres;
            } else {
                throw new SQLException("There are no genres in the database.");
            }
        }
    }
}
