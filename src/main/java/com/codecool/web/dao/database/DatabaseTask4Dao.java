package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;

import com.codecool.web.model.Task4Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTask4Dao extends AbstractDao implements Task4Dao {


    public DatabaseTask4Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task4Result> findAll() throws SQLException {

        List<Task4Result> task4Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company, ARRAY_AGG(order_id) AS \"Order IDs\" FROM customers " +
                     "LEFT JOIN orders ON customers.customer_id = orders.customer_id " +
                     "GROUP BY Company " +
                     "ORDER BY Company;";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task4Results.add(fetchResult(resultSet));
            }
        }
        return task4Results;
    }

    @Override
    public List<Task4Result> filter(String company) throws SQLException {

        List<Task4Result> task4Results = new ArrayList<>();

        String sql = "SELECT company_name AS Company, ARRAY_AGG(order_id) AS \"Order IDs\" FROM customers " +
            "LEFT JOIN orders ON customers.customer_id = orders.customer_id " +
            "GROUP BY Company " +
            "HAVING company_name = ? " +
            "ORDER BY Company;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task4Results.add(fetchResult(resultSet));
                }
            }
        }
        return task4Results;
    }

    private Task4Result fetchResult(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("Company");
        Array array = resultSet.getArray("Order IDs");
        Object [] orders =  (Object[]) array.getArray();
        List<Short> ints = new ArrayList<>();
        for (Object object : orders){
            ints.add((Short)object);
        }
        return new Task4Result(company, ints);
    }
}
