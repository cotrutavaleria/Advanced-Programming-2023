package compulsory.entities;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries({
        @javax.persistence.NamedQuery(name = "Album.findByTitle",
                query = "SELECT a FROM Album a WHERE a.title = :title"),
        @javax.persistence.NamedQuery(name = "Album.findById",
                query = "SELECT a FROM Album a WHERE a.id = :id")
})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "release_year")
    private Integer release_year;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;

    public Album(){}
    public Album (int release_year, String title, String artist){
        this.release_year = release_year;
        this.title = title;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", release_year=" + release_year +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
