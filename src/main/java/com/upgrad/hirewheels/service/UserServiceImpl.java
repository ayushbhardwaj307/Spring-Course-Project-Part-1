package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.UserRoleDAO;
import com.upgrad.hirewheels.dto.LoginDTO;
import com.upgrad.hirewheels.dto.UsersDTO;
import com.upgrad.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Override
    public User createUser(UsersDTO userDTO) throws Exception {
        User User1 = userDAO.findByEmail(userDTO.getEmail());
        if ( User1 != null) {
            throw new Exception("Email Already Exists");
        }
        User User2 = userDAO.findByMobileNo(userDTO.getMobileNo());
        if (User2 != null) {
            throw new Exception("Mobile Number Already Exists");
        }
        User user = new User();
        user.setWalletMoney(userDTO.getWalletMoney());
        user.setUserRole(userRoleDAO.findByRoleId(2));
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobileNo(userDTO.getMobileNo());
        return userDAO.save(user);
    }


    public User getUserDetails(LoginDTO loginDTO) throws Exception {
        User User = userDAO.findByEmail(loginDTO.getEmail());
        if (User == null){
            throw new Exception("User Not Registered");
        }
        User user = userDAO.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (user == null){
            throw new Exception("Unauthorized User");
        }
        return user;
    }

}
