package compulsory.repositories;

import compulsory.entities.Artist;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private final EntityManager em;

    public ArtistRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(Artist artist) {
        em.persist(artist);//inserts into table
        em.getTransaction().commit();
    }
    public List<Artist> findByName(String name) {
        return em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
    }
    public List<Artist> findById(int id) {
        return em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();
    }
}
