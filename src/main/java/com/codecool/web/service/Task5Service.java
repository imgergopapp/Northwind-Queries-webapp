package com.codecool.web.service;

import com.codecool.web.model.Task5Result;
import com.codecool.web.service.exception.InvalidFormException;

import java.sql.SQLException;
import java.util.List;

public interface Task5Service {
    List<Task5Result> getResults() throws SQLException;

    List<Task5Result> getFilteredResults(double minPrince) throws SQLException, InvalidFormException;
}
