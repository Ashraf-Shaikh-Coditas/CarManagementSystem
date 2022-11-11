package com.controller;

import com.bean.Booking;
import com.bean.Customer;
import com.bean.Store;
import com.util.FactoryProvider;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/BookingServlet")
public class AddBookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date date = Date.valueOf(req.getParameter("date"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        int customerId = Integer.parseInt(req.getParameter("customerid"));
        int carId = Integer.parseInt(req.getParameter("modelid"));
        Date expectedDate = Date.valueOf(req.getParameter("deliverytime"));

        EntityManager entityManager = FactoryProvider.getFactory().createEntityManager();
        Customer customer = entityManager.find(Customer.class,customerId);
        Store store = entityManager.find(Store.class,carId);
        Booking booking = new Booking(date,expectedDate,amount,customer,store);
        entityManager.persist(booking);
        entityManager.getTransaction().begin();

        store.setQuantity(store.getQuantity()-1);

        entityManager.getTransaction().commit();

    }
}
