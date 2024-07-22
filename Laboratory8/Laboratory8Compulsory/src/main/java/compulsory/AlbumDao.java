package compulsory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
    public AlbumDao() {
    }

    public void create(int year, String title, String artist) throws SQLException {
        Connection con = Singleton.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO albums (release_year, title, artist) VALUES (?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Album> findByName(String title) throws SQLException {
        Connection con = Singleton.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM albums WHERE title = '" + title + "'")) {
            List<Album> foundAlbums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int year = rs.getInt(2);
                String name = rs.getString(3);
                String artist = rs.getString(4);
                Album album = new Album(id, year, name, artist);
                foundAlbums.add(album);
            }
            if (!foundAlbums.isEmpty()) {
                return foundAlbums;
            }else{
                throw new SQLException("There are no albums in the database.");
            }
        }
    }
    public List<Album> getAll() throws SQLException {
        Connection con = Singleton.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM albums")) {
            List<Album> foundAlbums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int year = rs.getInt(2);
                String name = rs.getString(3);
                String artist = rs.getString(4);
                Album album = new Album(id, year, name, artist);
                foundAlbums.add(album);
            }
            if (!foundAlbums.isEmpty()) {
                return foundAlbums;
            }else{
                throw new SQLException("There are no albums in the database.");
            }
        }
    }

}
