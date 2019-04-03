package com.codecool.web.service.simple;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4Result;
import com.codecool.web.service.Task4Service;
import java.sql.SQLException;
import java.util.List;

public class SimpleTask4Service implements Task4Service {
    private final Task4Dao task4Dao;

    public SimpleTask4Service(Task4Dao task4Dao) throws SQLException {
        this.task4Dao = task4Dao;
    }

    public List<Task4Result> getResults() throws SQLException {
        return task4Dao.findAll();
    }
}
