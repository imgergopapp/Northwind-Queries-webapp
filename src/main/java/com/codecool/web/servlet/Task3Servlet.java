package com.codecool.web.servlet;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.dao.database.DatabaseTask3Dao;
import com.codecool.web.model.Task3Result;
import com.codecool.web.service.Task3Service;
import com.codecool.web.service.exception.InvalidFormException;
import com.codecool.web.service.simple.SimpleTask3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {

            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service task3Service = new SimpleTask3Service(task3Dao);
            List<Task3Result> task3results = task3Service.getResults();

            req.setAttribute("result3", task3results);
            req.getRequestDispatcher("task3.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service task3Service = new SimpleTask3Service(task3Dao);
            if (req.getParameter("order") == null) {
                throw new InvalidFormException("ERROR! Select a radio-button!");
            }
            if (req.getParameter("order").equals("desc")) {
                List<Task3Result> task3results = task3Service.getOrderDescResults();
                req.setAttribute("result3", task3results);
                req.getRequestDispatcher("task3.jsp").forward(req, resp);
            } else {
                doGet(req, resp);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (InvalidFormException ife) {
            req.setAttribute("errorMsg", ife.getMessage());
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        }
    }
}
