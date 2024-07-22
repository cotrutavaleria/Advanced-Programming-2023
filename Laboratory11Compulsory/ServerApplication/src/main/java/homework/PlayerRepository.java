package homework;


import javax.persistence.EntityManager;

public class PlayerRepository {
    private final EntityManager em;

    public PlayerRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(Player player) {
        em.persist(player);
    }

}
