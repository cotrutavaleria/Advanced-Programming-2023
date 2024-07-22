package homework.repositories;

import homework.entities.Artist;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class ArtistRepository extends DataRepository {
    private final EntityManager em;

    public ArtistRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List findById(Serializable id) {
        return em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public void create(Artist artist) {
        em.persist(artist);
    }

    @Override
    public List findByName(String name) {
        return em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
    }
}
