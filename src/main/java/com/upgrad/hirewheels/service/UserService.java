package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dto.usersDTO;


public interface UserService{
    users createUser(usersDTO users) throws Exception;
}