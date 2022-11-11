package com.dao;

import com.bean.Store;
import com.util.FactoryProvider;

import javax.persistence.EntityManager;

public class StoreDaoImplementation {
    public void addStock(Store store) {
        EntityManager entityManager = FactoryProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(store);
        entityManager.getTransaction().commit();
    }
}
