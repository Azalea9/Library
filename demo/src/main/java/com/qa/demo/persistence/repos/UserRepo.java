package com.qa.demo.persistence.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.persistence.domain.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long>{
    List<User> findUserBylibId(Long libId);
}
