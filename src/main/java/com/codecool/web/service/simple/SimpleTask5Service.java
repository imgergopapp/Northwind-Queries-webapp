package com.codecool.web.service.simple;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5Result;
import com.codecool.web.service.Task5Service;
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
}
