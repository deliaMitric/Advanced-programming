package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    private static EntityManagerFactory em;

    private Manager() {
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        if (em == null) {
            synchronized (Manager.class) {
                if (em == null) {
                    em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return em;
    }
    public static void closeEntityManagerFactory() {
        if (em != null && em.isOpen()) {
            em.close();
            em = null;
        }
    }
}
