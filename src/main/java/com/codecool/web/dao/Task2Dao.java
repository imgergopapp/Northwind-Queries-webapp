package com.codecool.web.dao;

import com.codecool.web.model.Task2Result;

import java.sql.SQLException;
import java.util.List;

public interface Task2Dao {

    List<Task2Result> findAll() throws SQLException;

}
