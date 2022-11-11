package com.controller;


import com.bean.Store;
import com.dao.StoreDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("carid"));
        String name = req.getParameter("carname");
        String model = req.getParameter("carmodel");
        int price = Integer.parseInt(req.getParameter("carprice"));
        int time = Integer.parseInt(req.getParameter("delivery"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Store store = new Store(id,name,model,price,time,quantity);
        System.out.println(store);

        StoreDaoImplementation storeDaoImplementation = new StoreDaoImplementation();
        storeDaoImplementation.addStock(store);

        printWriter.println("<h1>Stock Added Successfully</h1>");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req,resp);

    }
}
