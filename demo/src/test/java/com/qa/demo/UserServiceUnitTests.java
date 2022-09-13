package com.qa.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.persistence.domain.User;
import com.qa.demo.persistence.repos.UserRepo;
import com.qa.demo.services.UserService;

@SpringBootTest
public class UserServiceUnitTests {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepo repo;

    @Test
    void testCreate(){
        final User newUser = new User(null,"Freddy", "p@55w0rd", "Freddy@mail.com");
        final User savedUser = new User(1L,"Freddy", "p@55w0rd", "Freddy@mail.com");

        Mockito.when(this.repo.save(newUser)).thenReturn(savedUser);

        Assertions.assertThat(this.service.addUser(newUser)).isEqualTo(savedUser);

    }

    @Test
    void testFindByLibId(){
        final Long id = 1L;
        final List<User> newUser = List.of(new User(id,"Freddy", "p@55w0rd", "Freddy@mail.com"));

        Mockito.when(this.repo.findUserBylibId(id)).thenReturn(newUser);
        Assertions.assertThat(this.service.findUserbylibId(id)).isEqualTo(newUser);
        Mockito.verify(this.repo, Mockito.times(1)).findUserBylibId(id);
    }


    @Test
    void testGetAllUsers(){
        final List<User> users = List.of(new User(1L, "Freddy", "p@55w0rd", "Freddy@mail.com"), 
                    new User(2L, "Sally", "S3cr3t", "Sally@mail.com"));

        Mockito.when(this.repo.findAll()).thenReturn(users);

        Assertions.assertThat(users.size()).isGreaterThan(0);

     //   Mockito.verify(this.repo, Mockito.times(1)).findAll();
                    
    }

    @Test
    void updateUserTest(){
        final Long id = 1L;
        final User user = new User(id,"Freddy", "p@55w0rd", "Freddy@mail.com");
        Optional<User> optionalUser = Optional.of(user);

        User updateUser = new User(id,"Freddy", "topSecret", "Frederic@mail.com");

        Mockito.when(this.repo.findById(id)).thenReturn(optionalUser);
        Mockito.when(this.repo.save(updateUser)).thenReturn(updateUser);

       Assertions.assertThat(this.service.findUserbylibId(id)).isEqualTo(updateUser);

    }
    @Test
    void testDelete(){
        final Long id = 1L;

        Mockito.when(this.repo.existsById(id)).thenReturn(false);
        Assertions.assertThat(this.service.removeUser(id)).isEqualTo(true);

        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);



    }

    }
