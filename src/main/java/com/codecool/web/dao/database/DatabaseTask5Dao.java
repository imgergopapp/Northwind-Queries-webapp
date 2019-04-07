package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask5Dao extends AbstractDao implements Task5Dao {


    public DatabaseTask5Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task5Result> findAll() throws SQLException {

        List<Task5Result> task5Results = new ArrayList<>();

        String sql ="SELECT * FROM( " +
            "SELECT DISTINCT ON (company_name) company_name AS Company, product_name AS Product, unit_price AS Price FROM suppliers " +
            "INNER JOIN products ON products.supplier_id = suppliers.supplier_id "+
            "ORDER BY company_name, Price DESC ) As foo " +
            "ORDER BY Price DESC, Product, Company ;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task5Results.add(fetchResult(resultSet));
            }
        }
        return task5Results;
    }

    @Override
    public List<Task5Result> filter(double minPrice) throws SQLException {

        List<Task5Result> task5Results = new ArrayList<>();


        String sql ="SELECT * FROM( " +
            "SELECT DISTINCT ON (company_name) company_name AS Company, product_name AS Product, unit_price AS Price FROM suppliers " +
            "INNER JOIN products ON products.supplier_id = suppliers.supplier_id "+
            "ORDER BY company_name, Price DESC ) As foo " +
            "WHERE Price >= ? " +
            "ORDER BY Price DESC, Product, Company ;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, minPrice);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task5Results.add(fetchResult(resultSet));
                }
            }
        }
        return task5Results;
    }


    private Task5Result fetchResult(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        String product = resultSet.getString("Product");
        double price = resultSet.getDouble("Price");

        return new Task5Result(company, product, price);
    }
}
