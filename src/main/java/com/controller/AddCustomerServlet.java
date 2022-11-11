package com.controller;

import com.bean.Customer;
import com.dao.CustomerDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");

        Customer customer = new Customer(name);

        new CustomerDaoImplementation().addCustomer(customer);

        printWriter.println("<h1>Customer Added Successfully</h1>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req,resp);
    }
}
