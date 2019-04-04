package com.codecool.web.dao;

import com.codecool.web.model.Task4Result;

import java.sql.SQLException;
import java.util.List;

public interface Task4Dao {

    List<Task4Result> findAll() throws SQLException;
    List<Task4Result> filter(String company) throws SQLException;


}
