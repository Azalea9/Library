package com.qa.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.persistence.domain.User;
import com.qa.demo.persistence.repos.UserRepo;

@Service
public class UserService {
    private UserRepo repo;

    public UserService(UserRepo repo){
        super();
        this.repo = repo;
    }

    //Create a User
    public User addUser(User user){
        return this.repo.save(user);
    }

    //Get all Users
    public List<User> getAllUsers(){
       
        return this.repo.findAll();
    }

    //Get an individual user by username
    // TO DO


    //Update - update email address
    //TO DO

    // removes a user by id
    public boolean removeUser(Long id){
    
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;


    }
}
