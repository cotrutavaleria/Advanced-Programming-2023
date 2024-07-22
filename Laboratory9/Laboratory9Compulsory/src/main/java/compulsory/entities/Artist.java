package compulsory.entities;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT a FROM Artist a WHERE a.name = :name"),
        @NamedQuery(name = "Artist.findById",
                query = "SELECT a FROM Artist a WHERE a.id = :id")
})
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
