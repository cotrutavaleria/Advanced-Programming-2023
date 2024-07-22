package optional;

public class Album extends Table {
    private String title, artist;
    private int year_release;

    public Album(int year_release, String title, String artist) {
        this.year_release = year_release;
        this.title = title;
        this.artist = artist;
    }

    protected void setId(int id) {
        this.id = id;
    }
    public int getYear_release() {
        return year_release;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", id=" + id +
                ", year_release=" + year_release +
                '}';
    }
}
