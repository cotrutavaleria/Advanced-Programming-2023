package homework.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artist a WHERE a.name = :name"),
        @NamedQuery(name = "Artist.findById",
                query = "SELECT a FROM Artist a WHERE a.id = :id")
})
public class Artist extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @ManyToMany(targetEntity = Album.class, cascade = CascadeType.ALL)
    private List albumList;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List albumList) {
        this.albumList = albumList;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", albumList=" + albumList +
                '}';
    }
}
