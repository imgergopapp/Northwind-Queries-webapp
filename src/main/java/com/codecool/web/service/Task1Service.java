package com.codecool.web.service;

import com.codecool.web.model.Task1Result;

import java.sql.SQLException;
import java.util.List;

public interface Task1Service {
    List<Task1Result> getResults() throws SQLException;
    List<Task1Result> getFilteredResults(int limit) throws SQLException;

}
