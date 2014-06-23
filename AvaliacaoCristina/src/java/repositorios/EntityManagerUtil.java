package repositorios;

import javax.persistence.*;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private EntityManagerUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("persistence");
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}