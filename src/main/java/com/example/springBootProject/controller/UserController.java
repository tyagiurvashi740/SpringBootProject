package com.example.springBootProject.controller;

import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.User;
import com.example.springBootProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void  addUsers(@Valid @RequestBody User user){
        userService.registerUser(user);

    }

    @GetMapping("/users")
    public List<User> retrieveUsers() {
        return userService.retrieveAllUsers();

    }
    @GetMapping("/users/{id}")
    public User retrieveByID(@PathVariable Integer id) throws UserNotFoundException{
        return userService.retrieveById(id);
    }

    @PutMapping("/user/{id}")
    public void updateUSer(@RequestBody User user,@PathVariable Integer id) throws UserNotFoundException{
        userService.updateUser(user,id);

    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException{
        userService.deleteUser(id);

    }


    }





