package bonus;

import optional.Table;

public class PlaylistAlbums extends Table {
    private int idPlaylist, idAlbum;

    public PlaylistAlbums(int idPlaylist, int idAlbum) {
        this.idPlaylist = idPlaylist;
        this.idAlbum = idAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlaylistAlbums{" + " id=" + id +
                ", idPlaylist=" + idPlaylist +
                ", idAlbum=" + idAlbum +
                '}';
    }
}
