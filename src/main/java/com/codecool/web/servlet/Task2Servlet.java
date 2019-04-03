package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.DatabaseTask1Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.model.Task1Result;
import com.codecool.web.model.Task2Result;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.simple.SimpleTask1Service;
import com.codecool.web.service.simple.SimpleTask2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task2")
public final class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {

            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service task2Service = new SimpleTask2Service(task2Dao);
            List<Task2Result> task2results = task2Service.getResults();

            req.setAttribute("result2", task2results);
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
