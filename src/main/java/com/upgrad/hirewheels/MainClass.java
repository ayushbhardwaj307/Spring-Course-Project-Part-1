package com.upgrad.hirewheels;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context =new FileSystemXmlApplicationContext("src/main/resources/Beans.xml");
//        usersDAO usersDAO = (com.upgrad.hirewheels.dao.usersDAO) context.getBean("usersDAO");
//        roleDAO roleDAO = (com.upgrad.hirewheels.dao.roleDAO) context.getBean("roleDAO");
//        role role1= new role("ADMIN");
//        users user1= new users("Admin","Admin","9999999999","upgrad@gmail.com","admin@123",10000,role1);
//        roleDAO.save(role1);
//        usersDAO.save(user1);
//        role role2= new role("User");
//        users user2= new users("Admin","Admin","9999988899","upgraaaaad@gmail.com","adminis@123",20000,role2);
//        roleDAO.save(role2);
//        usersDAO.save(user2);
////        roleDAO.saveAndFlush(role1);
//
        System.out.println("Complete");

    }
}
