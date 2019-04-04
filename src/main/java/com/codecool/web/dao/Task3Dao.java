package com.codecool.web.dao;

import com.codecool.web.model.Task3Result;

import java.sql.SQLException;
import java.util.List;

public interface Task3Dao {

    List<Task3Result> findAll() throws SQLException;
    List<Task3Result> orderDesc() throws SQLException;

}
