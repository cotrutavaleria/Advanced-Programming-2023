package homework.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    public abstract Integer getId();

    public abstract void setId(Integer id);

    @Override
    public String toString() {
        return super.toString();
    }
}
