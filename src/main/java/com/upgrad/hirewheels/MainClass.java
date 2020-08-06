package com.upgrad.hirewheels;
import com.upgrad.hirewheels.dto.*;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.service.InitService;
import com.upgrad.hirewheels.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) throws Exception {
        ApplicationContext context =new FileSystemXmlApplicationContext("src/main/resources/Beans.xml");
        /**
         * Checking checkpoint 4.6
         */
//        InitService InitService = (InitService) context.getBean("InitService");
//        InitService.start();
//        UserService userService = (UserService) context.getBean("UserService");
//        UsersDTO usersDTO = new UsersDTO();
//        usersDTO.setEmail("upgrad@gmail.com");
//        usersDTO.setFirstName("Admin");
//        usersDTO.setLastName("Admin");
//        usersDTO.setMobileNo("9999999999");
//        usersDTO.setPassword("admin@123");
//        usersDTO.setWalletMoney(10000);
//        userService.createUser(usersDTO);


        System.out.println("Complete");

    }
}
