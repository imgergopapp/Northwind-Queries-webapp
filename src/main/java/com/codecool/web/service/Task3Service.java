package com.codecool.web.service;

import com.codecool.web.model.Task3Result;
import com.codecool.web.service.exception.InvalidFormException;

import java.sql.SQLException;
import java.util.List;

public interface Task3Service {
    List<Task3Result> getResults() throws SQLException;

    List<Task3Result> getOrderDescResults() throws SQLException;
}
