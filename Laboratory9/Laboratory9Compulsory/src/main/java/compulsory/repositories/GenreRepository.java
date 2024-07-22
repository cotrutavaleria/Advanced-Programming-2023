package compulsory.repositories;

import compulsory.entities.Genre;

import javax.persistence.EntityManager;
import java.util.List;

public class GenreRepository {
    private final EntityManager em;

    public GenreRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(Genre genre) {
        em.persist(genre);//inserts into table
        em.getTransaction().commit();
    }
    public List<Genre> findByTitle(String name) {
        return em.createNamedQuery("Genre.findByName")
                .setParameter("name", name)
                .getResultList();
    }
    public List<Genre> findById(int id) {
        return em.createNamedQuery("Genre.findById")
                .setParameter("id", id)
                .getResultList();
    }
}
