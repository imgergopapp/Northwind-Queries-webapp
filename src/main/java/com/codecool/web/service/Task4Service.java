package com.codecool.web.service;

import com.codecool.web.model.Task4Result;

import java.sql.SQLException;
import java.util.List;

public interface Task4Service {
    List<Task4Result> getResults() throws SQLException;

    List<Task4Result> getFilteredResults(String company) throws SQLException;
}
