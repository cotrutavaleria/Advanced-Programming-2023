package optional;

public class ImportedAlbum extends Table {
    private String title, artist, genre, subgenre;
    private int year;
    public ImportedAlbum(int year_release, String title, String artist, String genre, String subgenre) {
        this.year = year_release;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.subgenre = subgenre;
    }

    protected void setId(int id) {
        this.id = id;
    }
    public int getYear_release() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ImportedAlbum{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", subgenre='" + subgenre + '\'' +
                ", year=" + year +
                ", id=" + id +
                '}' + "\n";
    }
}
