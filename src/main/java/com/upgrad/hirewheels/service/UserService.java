package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UsersDTO;
import com.upgrad.hirewheels.entities.User;


public interface UserService{
    User createUser(UsersDTO users) throws Exception;
    User getUserDetails(LoginDTO loginDTO) throws Exception;
}