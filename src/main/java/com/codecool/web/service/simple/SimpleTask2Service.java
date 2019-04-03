package com.codecool.web.service.simple;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task1Result;
import com.codecool.web.model.Task2Result;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.Task2Service;

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
}
