package com.service.example.services;

import com.service.example.dao.UserDao;
import com.service.example.model.User;

public class UserService {

    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresence(User user) throws Exception {
        User u = dao.getUserByUsername(user.getUsername());
        return u != null;
    }
}
