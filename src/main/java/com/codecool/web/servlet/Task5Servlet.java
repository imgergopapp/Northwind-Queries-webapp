package com.codecool.web.servlet;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.Task4Dao;
import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.dao.database.DatabaseTask4Dao;
import com.codecool.web.dao.database.DatabaseTask5Dao;
import com.codecool.web.model.Task2Result;
import com.codecool.web.model.Task4Result;
import com.codecool.web.model.Task5Result;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.Task4Service;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.exception.InvalidFormException;
import com.codecool.web.service.simple.SimpleTask2Service;
import com.codecool.web.service.simple.SimpleTask4Service;
import com.codecool.web.service.simple.SimpleTask5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task5")
public final class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {

            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);
            List<Task5Result> task5results = task5Service.getResults();

            req.setAttribute("result5", task5results);
            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            double minPrince = Double.valueOf(req.getParameter("minPrice"));

            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);
            List<Task5Result> task5results = task5Service.getFilteredResults(minPrince);

            req.setAttribute("result5", task5results);
            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (InvalidFormException ife) {
            req.setAttribute("errorMsg", ife.getMessage());
            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        }
    }
}
