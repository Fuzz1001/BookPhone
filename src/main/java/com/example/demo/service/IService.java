package com.example.demo.service;

import com.example.demo.entity.Kniga;

import java.sql.SQLException;
import java.util.List;


public interface IService {

    //create
    Integer add(Kniga kniga) throws SQLException;

    //read
    List<Kniga> getAll() throws SQLException;

    //byId
    Kniga getById(Long id) throws SQLException;

    //update
    Integer update(Kniga kniga) throws SQLException;

    //delete
    Long remove(Long id) throws SQLException;

}
