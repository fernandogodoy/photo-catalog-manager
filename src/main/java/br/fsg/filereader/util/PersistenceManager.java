package br.fsg.filereader.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("fileManagerPU");
    }
    
    public static EntityManager getEntityManager() {
    	if(entityManager == null) {
    		entityManager = entityManagerFactory.createEntityManager();
    	}
        return entityManager;
    }

    public static void main(String[] args) {
        new PersistenceManager();
        System.exit(0);
    }

}
