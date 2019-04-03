package com.codecool.web.service;

import com.codecool.web.model.Task5Result;

import java.sql.SQLException;
import java.util.List;

public interface Task5Service {
    List<Task5Result> getResults() throws SQLException;
}
