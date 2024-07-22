package optional;

public class AlbumGenre extends Table {
    private int albumId, genreId;

    public AlbumGenre(int albumId, int genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getGenreId() {
        return genreId;
    }

    @Override
    public String toString() {
        return "AlbumGenre{" +
                ", id=" + id +
                "albumId=" + albumId +
                ", genreId=" + genreId +
                '}';
    }
}
