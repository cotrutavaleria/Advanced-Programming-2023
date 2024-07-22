package compulsory;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public Test() {

    }

    public void testTheClasses() {
        try {
            Singleton.createConnection();
            var artists = new ArtistDao();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            Artist artist = artists.findById(100);
            System.out.println("Artists found by id: " + artist);
            int artistId = artists.findByName("Michael Jackson");
            System.out.println("Artists found by name: " + artistId);
            var genres = new GenreDao();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            var albums = new AlbumDao();
            albums.create(1979, "The Wall", "Pink Floyd");
            albums.create(1982, "Thriller", "Michael Jackson");
            List<Album> albumList = albums.findByName("Thriller");
            System.out.println("Albums found by name: " + albumList);
            System.out.println("All the albums recorded:" + albums.getAll());
            Singleton.getConnection().close();
        } catch (SQLException | IllegalAccessException e) {
            System.err.println(e);
            Singleton.rollback();
        }
    }
}
