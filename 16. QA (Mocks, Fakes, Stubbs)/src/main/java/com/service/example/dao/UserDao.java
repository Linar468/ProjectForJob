package com.service.example.dao;

import com.service.example.model.User;

import java.util.List;

public interface UserDao {

    User getUserByUsername(String username) throws Exception;

    List<User> findAllUsers();
}
