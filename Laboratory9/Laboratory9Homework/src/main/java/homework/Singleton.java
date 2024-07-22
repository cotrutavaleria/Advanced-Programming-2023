package homework;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
    private static final String PERSISTENCE_UNIT_NAME = "laboratory9";
    private static EntityManagerFactory entityManagerFactory;

    private Singleton() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
