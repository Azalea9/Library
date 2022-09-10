package com.qa.demo.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.persistence.domain.User;
import com.qa.demo.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        
        super();
        this.userService = userService;
    }

    @GetMapping("/test")
    public String getTest(){
        return "Hello";
    }

    // Get all users
    @GetMapping("/getAll/users/") 
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    // Create a new user
    @PostMapping("/create/user")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    // Update email address
    //TO DO

    // delete a user
    @DeleteMapping("/delete/user/{id}")
    public Boolean removeUser(@PathVariable Long id){
        return this.userService.removeUser(id);
    }
 

}
