package bonus;

import com.github.javafaker.Faker;
import optional.AlbumDao;
import optional.ConnectionPool;
import optional.ImportData;
import optional.ImportedAlbum;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreatePlaylistAlgorithm {
    private Connection connection = null;
    private ConnectionPool connectionPool;
    private PlaylistDao playlists;
    private PlaylistAlbumsDao playlistAlbums;
    private Faker fakerName;

    public CreatePlaylistAlgorithm() {
        this.connectionPool = new ConnectionPool();
        connection = this.connectionPool.getConnection();
        this.playlists = new PlaylistDao();
        this.playlistAlbums = new PlaylistAlbumsDao();
        this.fakerName = new Faker();
    }

    public void createPlaylist() throws SQLException {
        List<Playlist> listOfPlaylists = new ArrayList<>();
        listOfPlaylists = playlists.getAll();
        if (listOfPlaylists == null) {
            addToPlaylist(1);
            addOtherAlbums();
        } else {
            addOtherAlbums();
        }

    }

    public void addToPlaylist(int idAlbum) throws SQLException {
        this.playlists.create(new Playlist(this.fakerName.music().instrument().toString() + " " + this.fakerName.music().genre().toString()));
        this.playlistAlbums.create(new PlaylistAlbums(this.playlists.getMaxId(), idAlbum));
    }

    public void addOtherAlbums() throws SQLException {
        int idAlbum, minId = this.playlists.getMinId();
        var importedAlbum = new ImportData();
        int maxIdExportedAlbums = importedAlbum.getMaxId();
        for (idAlbum = 2; idAlbum <= maxIdExportedAlbums; idAlbum++) {
            int nrOfPlaylists;
            for (nrOfPlaylists = minId; nrOfPlaylists <= this.playlists.getMaxId(); nrOfPlaylists++) {
                int mismatchedAlbums = 0;
                List<Integer> albums = this.playlistAlbums.findByIdPlaylist(nrOfPlaylists);//iau lista de albume din primul;curent playlist
                for (int index = 0; index < albums.size(); index++) {
                    ImportedAlbum album1 = importedAlbum.findById(albums.get(index));//albumul curent din playllist_album
                    ImportedAlbum album2 = importedAlbum.findById(idAlbum);//albumul curent din exported_albums
                    if ((album2.getYear_release() != album1.getYear_release()) && !album2.getArtist().equals(album1.getArtist())) {
                        String genre1 = album1.getGenre(), genre2 = album2.getGenre();
                        String[] splitGenres1 = genre1.split(",");
                        int count = 0;
                        for (int index1 = 0; index1 < splitGenres1.length; index1++) {
                            if (genre2.contains(splitGenres1[index1])) {
                                break;
                            } else {
                                count++;
                                if (!genre2.contains(splitGenres1[index1]) && index1 == splitGenres1.length - 1) {
                                    if (count == splitGenres1.length) {
                                        mismatchedAlbums++;
                                    }
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (mismatchedAlbums == albums.size()) {
                    if (this.playlistAlbums.findByIdAlbum(idAlbum) == 0) {
                        this.playlistAlbums.create(new PlaylistAlbums(nrOfPlaylists, idAlbum));
                        break;
                    }
                }
            }
            if (this.playlistAlbums.findByIdAlbum(idAlbum) == 0) {
                addToPlaylist(idAlbum);
            }
        }
        displayTheNumberOfPlaylists();
        displayTheFirstPlaylist();
    }

    public void displayTheNumberOfPlaylists() throws SQLException {
        System.out.println("The number of created playlists is: " + playlists.getMaxId());
    }
    public void displayTheFirstPlaylist() throws SQLException {
        var importedAlbums = new ImportData();
        List<Integer> albumsId = this.playlistAlbums.findByIdPlaylist(1);
        List<ImportedAlbum> playlist = new ArrayList<>();
        for(Integer album:albumsId){
            playlist.add(importedAlbums.findById(album));
        }
        System.out.println("The first playlist is: " + playlist);
    }
}
