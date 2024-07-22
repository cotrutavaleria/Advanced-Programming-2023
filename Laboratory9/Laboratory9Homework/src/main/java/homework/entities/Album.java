package homework.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "albums")
@NamedQueries({
        @javax.persistence.NamedQuery(name = "Album.findByTitle",
                query = "SELECT a FROM Album a WHERE a.title = :title"),
        @javax.persistence.NamedQuery(name = "Album.findById",
                query = "SELECT a FROM Album a WHERE a.id = :id")
})
public class Album extends AbstractEntity implements Serializable {
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

    @OneToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
    private List albumGenres;
    @ManyToMany(targetEntity = Artist.class, cascade = CascadeType.ALL)
    private List artistList;

    public Album() {
    }

    public Album(int release_year, String title, String artist) {
        this.release_year = release_year;
        this.title = title;
        this.artist = artist;
    }

    public List getArtistList() {
        return artistList;
    }

    public void setArtistList(List artistList) {
        this.artistList = artistList;
    }

    public List getAlbumGenres() {
        return albumGenres;
    }

    public void setAlbumGenres(List albumGenres) {
        this.albumGenres = albumGenres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
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
                ", albumGenres=" + albumGenres +
                ", artistList=" + artistList +
                '}';
    }
}
