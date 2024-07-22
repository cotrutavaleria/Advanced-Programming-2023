package compulsory.repositories;

import compulsory.entities.Album;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {
    private final EntityManager em;

    public AlbumRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(Album album) {
        em.persist(album);//inserts into table
        em.getTransaction().commit();
    }
    public List<Album> findByTitle(String title) {
        return em.createNamedQuery("Album.findByTitle")
                .setParameter("title", title)
                .getResultList();
    }
    public List<Album> findById(int id) {
        return em.createNamedQuery("Album.findById")
                .setParameter("id", id)
                .getResultList();
    }
}
