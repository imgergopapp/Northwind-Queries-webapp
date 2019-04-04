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

        String sql = "SELECT company_name AS Company,product_name AS Product, Price FROM ( " +
            "SELECT company_name, product_name, MAX(unit_price) AS Price FROM suppliers " +
            "INNER JOIN products ON products.supplier_id = suppliers.supplier_id " +
            "GROUP BY company_name, product_name) As foo " +
            "ORDER BY Price DESC, product_name, company_name;";

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

        String sql = "SELECT company_name AS Company,product_name AS Product, Price FROM ( " +
            "SELECT company_name, product_name, MAX(unit_price) AS Price FROM suppliers " +
            "INNER JOIN products ON products.supplier_id = suppliers.supplier_id " +
            "GROUP BY company_name, product_name " +
            "HAVING MAX(unit_price) >= ?) As foo " +
            "ORDER BY Price DESC, product_name, company_name;";

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
