package compulsory;


import java.sql.*;

public class ArtistDao {

    public ArtistDao() {}

//    private int getMaxId() throws SQLException {
//        PreparedStatement statement = null;
//        try {
//            statement = Singleton.getConnection().prepareStatement("SELECT MAX(id) FROM artists");
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                return id;
//            }
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return -1;
//    }

    public void create(String name) throws SQLException {
        Connection con = Singleton.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO artists (name) VALUES (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Artist findById(int id) throws IllegalAccessException {
        PreparedStatement statement = null;
        try {
            statement = Singleton.getConnection().prepareStatement("SELECT * FROM artists WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Artist artist = new Artist(id, name);
                return artist;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        throw new IllegalAccessException("There is no such artist. The id does not exist!");
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Singleton.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM artists WHERE name='" + name + "'")) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("There is no such artist! The name does not exist!");
            }
        }
    }

}
