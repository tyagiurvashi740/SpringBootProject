package com.example.springBootProject.service;

import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.User;

import java.util.List;

public interface UserService {
    public void registerUser(User user);
    List<User> retrieveAllUsers();

    void updateUser(User user, Integer id) throws UserNotFoundException;

    void deleteUser(Integer id) throws UserNotFoundException;

    User retrieveById(Integer id) throws UserNotFoundException ;
}
