package com.dao;

import com.bean.Customer;
import com.bean.Store;
import com.util.FactoryProvider;

import javax.persistence.EntityManager;

public class CustomerDaoImplementation {
    public void addCustomer(Customer customer) {
        EntityManager entityManager = FactoryProvider.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
}
