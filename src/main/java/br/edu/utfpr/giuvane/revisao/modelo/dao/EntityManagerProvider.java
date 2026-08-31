package br.edu.utfpr.giuvane.revisao.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Caio Macedo
 */
public class EntityManagerProvider {
    
    private static EntityManagerProvider instance;
    private EntityManagerFactory factory;
    
    private EntityManagerProvider() {
        factory = Persistence.createEntityManagerFactory("TDS-Revisao");
    }
    
    public static EntityManagerProvider getInstance() {
        if (instance == null) {
            instance = new EntityManagerProvider();
        }
        return instance;
    }
    
    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
    
    public void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
