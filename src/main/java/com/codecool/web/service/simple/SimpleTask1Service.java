package com.codecool.web.service.simple;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1Result;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.exception.InvalidFormException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTask1Service implements Task1Service {
    private final Task1Dao task1Dao;

    public SimpleTask1Service(Task1Dao task1Dao) throws SQLException {
        this.task1Dao = task1Dao;
    }

    public List<Task1Result> getResults() throws SQLException {
        return task1Dao.findAll();
    }

    @Override
    public List<Task1Result> getFilteredResults(int limit) throws SQLException, InvalidFormException {
        List<Task1Result> results = task1Dao.findAll();
        if (limit < 0 || limit > results.size()) {
            throw new InvalidFormException("ERROR! The Limit should be 0 <= Limit <= " + results.size() + " !");
        }

        return task1Dao.filter(limit);
    }
}
