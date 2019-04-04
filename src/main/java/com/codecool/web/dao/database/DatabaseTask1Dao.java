package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask1Dao extends AbstractDao implements Task1Dao {


    public DatabaseTask1Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1Result> findAll() throws SQLException {

        List<Task1Result> task1Results = new ArrayList<>();

        //Task 1 answer
        String sql = "SELECT product_name AS Product, company_name AS Company FROM products " +
            "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
            "ORDER BY product, company;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task1Results.add(fetchResult(resultSet));
            }
        }
        return task1Results;
    }

    @Override
    public List<Task1Result> filter(int limit) throws SQLException {

        List<Task1Result> task1Results = new ArrayList<>();

        //Task 1 answer
        String sql = "SELECT product_name AS Product, company_name AS Company FROM products " +
            "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
            "ORDER BY product, company " +
            "LIMIT ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, limit);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task1Results.add(fetchResult(resultSet));
                }
            }
        }
        return task1Results;
    }

    private Task1Result fetchResult(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        String product = resultSet.getString("Product");
        return new Task1Result(product, company);
    }
}
