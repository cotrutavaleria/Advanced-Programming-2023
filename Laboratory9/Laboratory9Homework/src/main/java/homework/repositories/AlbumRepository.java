package homework.repositories;

import homework.entities.Album;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class AlbumRepository extends DataRepository {
    private final EntityManager em;

    public AlbumRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List findById(Serializable id) {
        return em.createNamedQuery("Album.findById")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List findByName(String name) {
        return em.createNamedQuery("Album.findByTitle")
                .setParameter("title", name)
                .getResultList();
    }

    public void create(Album album) {
        em.persist(album);
    }
}
