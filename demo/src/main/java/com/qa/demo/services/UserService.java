package com.qa.demo.services;

import java.util.List;
import java.util.Optional;

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

    //Get an individual user by libId
    public List<User> findUserbylibId(Long libId){
        return this.repo.findUserBylibId(libId);
    }


    //Update - update email address
    public User updateEmail(Long libId, User newUser){
        
        Optional<User> existingOptional = this.repo.findById(libId);
        User existing = existingOptional.get();
        existing.setUsername(newUser.getUsername());
        existing.setPassword(newUser.getPassword());
        existing.setNumOfBooksAllowed(newUser.getNumOfBooksAllowed());
        existing.setNumOfBooksOnLoan(newUser.getNumOfBooksOnLoan());
        existing.setEmail(newUser.getEmail());

        return this.repo.save(existing);
    }

    // removes a user by id
    public boolean removeUser(Long id){
    
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;


    }
}
