package compulsory;

import java.sql.*;

public class GenreDao {
    public GenreDao(){}
    public void create(String name) throws SQLException {
        Connection con = Singleton.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO genres (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Genre findById(int id) throws IllegalAccessException {
        PreparedStatement statement = null;
        try {
            statement = Singleton.getConnection().prepareStatement("SELECT * FROM genres WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Genre genre = new Genre(id, name);
                return genre;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        throw new IllegalAccessException("There is no such genre. The id does not exist!");
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Singleton.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM genres WHERE name='" + name + "'")) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("There is no such genre! The name does not exist!");
            }
        }
    }
}
