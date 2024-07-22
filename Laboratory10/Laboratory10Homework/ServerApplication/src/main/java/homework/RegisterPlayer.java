package homework;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RegisterPlayer {
    EntityManagerFactory emf = Singleton.getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    private Player player;
    public RegisterPlayer(Player player) {
        this.player = player;

    }
    public void register() {
        em.getTransaction().begin();
        PlayerRepository playerRepository = new PlayerRepository(em);
        playerRepository.create(player);
        em.getTransaction().commit();
        em.close();
        Singleton.closeEntityManagerFactory();
    }
}
