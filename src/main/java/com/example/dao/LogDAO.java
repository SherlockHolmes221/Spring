package com.example.dao;


import com.example.model.Log;

public interface LogDAO {

    public default void save(Log log) {
    }
	
	

}
