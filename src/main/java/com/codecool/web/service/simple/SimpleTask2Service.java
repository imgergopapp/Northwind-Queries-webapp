package com.codecool.web.service.simple;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2Result;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.exception.InvalidFormException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTask2Service implements Task2Service {
    private final Task2Dao task2Dao;

    public SimpleTask2Service(Task2Dao task2Dao) throws SQLException {
        this.task2Dao = task2Dao;
    }

    public List<Task2Result> getResults() throws SQLException {
        return task2Dao.findAll();
    }

    @Override
    public List<Task2Result> getFilteredResults(int minNumbOfProducts) throws SQLException, InvalidFormException {
        List<Task2Result> results = task2Dao.findAll();
        int minValue = results.get(results.size() - 1).getNumberOfProducts();
        int maxValue = results.get(0).getNumberOfProducts();
        if (minNumbOfProducts < minValue || minNumbOfProducts > maxValue) {
            throw new InvalidFormException("ERROR! The number should be " + minValue + " <= number <=" + maxValue + " !");
        }

        return task2Dao.filter(minNumbOfProducts);
    }
}
