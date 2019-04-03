package com.codecool.web.dao;

import com.codecool.web.model.Task5Result;

import java.sql.SQLException;
import java.util.List;

public interface Task5Dao {

    List<Task5Result> findAll() throws SQLException;

}
