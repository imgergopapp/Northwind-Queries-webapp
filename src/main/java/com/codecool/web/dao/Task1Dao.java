package com.codecool.web.dao;

import com.codecool.web.model.Task1Result;

import java.sql.SQLException;
import java.util.List;

public interface Task1Dao {

    List<Task1Result> findAll() throws SQLException;

    List<Task1Result> filter(int limit) throws SQLException;
}
