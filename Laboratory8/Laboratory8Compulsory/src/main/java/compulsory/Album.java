package compulsory;

public class Album {
    private String title, artist;
    private int  id, year_release;
    public Album(int id, int year_release, String title, String artist) {
        this.id = id;
        this.year_release = year_release;
        this.title = title;
        this.artist = artist;

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
