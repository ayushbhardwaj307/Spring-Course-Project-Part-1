package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.dto.usersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements UserService {

    @Qualifier("usersDAO")
    @Autowired
    usersDAO usersDAO;


    @Qualifier("roleDAO")
    @Autowired
    roleDAO roleDAO;

    @Override
    public users createUser(usersDTO usersDTO) throws Exception {
            users returnedUser = usersDAO.findByEmail(usersDTO.getEmail());
                if ( returnedUser != null) {
                    throw new Exception("Email Already Exists");
                }
            users returnedUser1 = usersDAO.findByMobileNo(usersDTO.getMobileNo());
            if (returnedUser1 != null) {
                throw new Exception("Mobile Number Already Exists");
                }
            users user = new users();
            user.setWallet_money(10000);
            user.setRole(roleDAO.findByrole_id(2));
            user.setEmail(usersDTO.getEmail());
            user.setPassword(usersDTO.getPassword());
            user.setFirst_name(usersDTO.getFirstName());
            user.setLast_name(usersDTO.getLastName());
            user.setMobile_no(usersDTO.getMobileNo());
            users savedUser = usersDAO.save(user);
            return savedUser;
    }

}
