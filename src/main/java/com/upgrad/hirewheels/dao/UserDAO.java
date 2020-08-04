package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByMobileNo(String mobileNo);
    User findByEmailAndPassword(String email, String password);
    }
