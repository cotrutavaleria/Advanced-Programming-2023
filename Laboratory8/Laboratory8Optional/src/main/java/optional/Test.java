package optional;

import bonus.CreatePlaylistAlgorithm;
import bonus.Playlist;
import bonus.PlaylistAlbumsDao;
import bonus.PlaylistDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public Test() {
    }

    public void testTheClasses() {
        try {
            var artists = new ArtistDao();
            artists.create(new Artist("Pink Floyd"));
            artists.create(new Artist("Michael Jackson"));
            System.out.println("Artists found by name: " + artists.findByName("Michael Jackson"));
            var genres = new GenreDao();
            genres.create(new Genre("Rock"));
            genres.create(new Genre("Funk"));
            genres.create(new Genre("Soul"));
            genres.create(new Genre("Pop"));
            var albums = new AlbumDao();
            albums.create(new Album(1979, "The Wall", "Pink Floyd"));
            albums.create(new Album(1982, "Thriller", "Michael Jackson"));
            System.out.println("Albums found by name: " + albums.findByName("Thriller"));
            System.out.println("All the albums recorded:" + albums.getAll());
            var albumGenres = new AlbumGenreDao();
            albumGenres.create(new AlbumGenre(1,1));
            albumGenres.create(new AlbumGenre(1,2));
            albumGenres.create(new AlbumGenre(1,4));
            albumGenres.create(new AlbumGenre(1,3));
            var importData = new ImportData();
            importData.readFromCsvFile();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public void bonusTesting() throws SQLException {
        CreatePlaylistAlgorithm algorithm = new CreatePlaylistAlgorithm();
        algorithm.createPlaylist();
    }
}
