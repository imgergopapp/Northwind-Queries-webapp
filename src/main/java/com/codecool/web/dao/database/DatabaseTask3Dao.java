package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask3Dao extends AbstractDao implements Task3Dao {


    public DatabaseTask3Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task3Result> findAll() throws SQLException {

        List<Task3Result> task3Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company,COUNT(DISTINCT product_name) AS NumberOfProducts FROM products " +
            "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
            "GROUP BY company " +
            "HAVING COUNT(DISTINCT product_name) = 5 " +
            "ORDER BY Company;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task3Results.add(fetchResult(resultSet));
            }
        }
        return task3Results;
    }

    @Override
    public List<Task3Result> orderDesc() throws SQLException {

        List<Task3Result> task3Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company,COUNT(DISTINCT product_name) AS NumberOfProducts FROM products " +
            "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
            "GROUP BY company " +
            "HAVING COUNT(DISTINCT product_name) = 5 " +
            "ORDER BY Company DESC;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task3Results.add(fetchResult(resultSet));
            }
        }
        return task3Results;
    }

    private Task3Result fetchResult(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        int product = resultSet.getInt("NumberOfProducts");
        return new Task3Result(company, product);
    }
}
