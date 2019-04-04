package com.codecool.web.service.simple;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Result;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.exception.InvalidFormException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTask5Service implements Task5Service {
    private final Task5Dao task5Dao;

    public SimpleTask5Service(Task5Dao task5Dao) throws SQLException {
        this.task5Dao = task5Dao;
    }


    public List<Task5Result> getResults() throws SQLException {
        return task5Dao.findAll();
    }


    @Override
    public List<Task5Result> getFilteredResults(double minPrince) throws SQLException, InvalidFormException {
        if (minPrince < 0){
            throw new InvalidFormException("ERROR ! Price should be not negative... !");
        }
        return task5Dao.filter(minPrince);
    }
}
