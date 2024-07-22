package homework.repositories;

import homework.entities.Genre;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class GenreRepository extends DataRepository {
    private final EntityManager em;

    public GenreRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(Genre genre) {
        em.persist(genre);//inserts into table
    }

    @Override
    public List findByName(String name) {
        return em.createNamedQuery("Genre.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List findById(Serializable id) {
        return em.createNamedQuery("Genre.findById")
                .setParameter("id", id)
                .getResultList();
    }
}
