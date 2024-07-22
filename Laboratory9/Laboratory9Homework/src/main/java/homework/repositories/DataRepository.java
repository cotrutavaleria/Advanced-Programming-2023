package homework.repositories;

import homework.entities.AbstractEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository<T extends AbstractEntity, Integer extends Serializable> {
    private EntityManager em;

    public DataRepository() {
    }

    public DataRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public abstract List<T> findById(Integer id);

    public abstract List<T> findByName(String name);

    public void create(T entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
