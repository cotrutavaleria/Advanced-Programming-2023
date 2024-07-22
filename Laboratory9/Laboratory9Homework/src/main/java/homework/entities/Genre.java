package homework.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genres")
@NamedQueries({
        @javax.persistence.NamedQuery(name = "Genre.findByName",
                query = "SELECT g FROM Genre g WHERE g.name = :name"),
        @javax.persistence.NamedQuery(name = "Genre.findById",
                query = "SELECT g FROM Genre g WHERE g.id = :id")
})
public class Genre extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Genre() {
    }

    public Genre(String name) {
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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
