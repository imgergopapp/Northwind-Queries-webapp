package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task1Result;
import com.codecool.web.model.Task2Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask2Dao extends AbstractDao implements Task2Dao {


    public DatabaseTask2Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task2Result> findAll() throws SQLException {

        List<Task2Result> task2Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company, COUNT( *)AS NumberOfProducts FROM products " +
                     "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
                     "GROUP BY company " +
                     "ORDER BY NumberOfProducts DESC, Company;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task2Results.add(fetchResult(resultSet));
            }
        }
        return task2Results;
    }

    @Override
    public List<Task2Result> filter(int minNumbOfProducts) throws SQLException {

        List<Task2Result> task2Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company, COUNT( *)AS NumberOfProducts FROM products " +
            "INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id " +
            "GROUP BY company " +
            "HAVING (COUNT(*)) >= ? " +
            "ORDER BY NumberOfProducts DESC, Company;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, minNumbOfProducts);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task2Results.add(fetchResult(resultSet));
                }
            }
        }
        return task2Results;
    }

    private Task2Result fetchResult(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        int product = resultSet.getInt("NumberOfProducts");
        return new Task2Result(company,product);
    }
}
