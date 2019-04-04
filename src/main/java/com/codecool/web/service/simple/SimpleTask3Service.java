package com.codecool.web.service.simple;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3Result;
import com.codecool.web.service.Task3Service;
import java.sql.SQLException;
import java.util.List;

public class SimpleTask3Service implements Task3Service {
    private final Task3Dao task3Dao;

    public SimpleTask3Service(Task3Dao task3Dao) throws SQLException {
        this.task3Dao = task3Dao;
    }

    public List<Task3Result> getResults() throws SQLException {
        return task3Dao.findAll();
    }
    public List<Task3Result> getOrderDescResults() throws SQLException {
        return task3Dao.orderDesc();
    }
}
