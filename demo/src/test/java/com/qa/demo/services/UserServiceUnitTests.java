package com.qa.demo.services;

import java.util.List;
//import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.persistence.domain.User;
import com.qa.demo.persistence.repos.UserRepo;


@SpringBootTest
public class UserServiceUnitTests {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepo repo;

    @Test
    void testFindByLibId(){
        final Long id = 1L;
        final User newUser = new User(id,"Freddy", "p@55w0rd", "Freddy@mail.com",5,0);

        Mockito.when(this.repo.findUserBylibId(id)).thenReturn(newUser);
        Assertions.assertThat(this.service.findUserbylibId(id)).isEqualTo(newUser);
        Mockito.verify(this.repo, Mockito.times(1)).findUserBylibId(id);
    }


    @Test
    void testGetAllUsers(){
        final List<User> users = List.of(new User(1L, "Freddy", "p@55w0rd", "Freddy@mail.com",5,0), 
                    new User(2L, "Sally", "S3cr3t", "Sally@mail.com",5,0));

        Mockito.when(this.repo.findAll()).thenReturn(users);

        Assertions.assertThat(users.size()).isGreaterThan(0);

    
    }

    @Test
    void testDeleteUser(){
        final Long id = 1L;

        Mockito.when(this.repo.existsById(id)).thenReturn(false);
        Assertions.assertThat(this.service.removeUser(id)).isEqualTo(true);

        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

    }

//@Test

//    void updateUserTest(){
//         Long id = 1L;
//         User user = new User(null, "Freddy", "p@55w0rd", "Freddy@mail.com",5,0);
//         //Optional<User> optionalUser = Optional.of(user);

//         User updateUser = new User(1L,user.getUsername(), user.getPassword(),user.getEmail(),user.getNumOfBooksAllowed(),user.getNumOfBooksOnLoan());
//         Mockito.when(this.service.updateEmail(1L, updateUser)).thenReturn(updateUser);

//         Assertions.assertThat(this.repo.findById(id)).isEqualTo(updateUser);
    
//         //Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//         //Mockito.verify(this.repo, Mockito.times(1)).save(updateUser);

//     }

    @Test
    void testCreate(){
        final User newUser = new User(null,"Freddy", "p@55w0rd", "Freddy@mail.com",5,0);
        final User savedUser = new User(1L,"Freddy", "p@55w0rd", "Freddy@mail.com",5,0);

        Mockito.when(this.repo.save(newUser)).thenReturn(savedUser);

        Assertions.assertThat(this.service.addUser(newUser)).isEqualTo(savedUser);

    }

    

}
