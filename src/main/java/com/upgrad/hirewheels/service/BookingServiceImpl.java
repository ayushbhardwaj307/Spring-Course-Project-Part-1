package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.BookingDAO;
import com.upgrad.hirewheels.dao.LocationDAO;
import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.dto.BookingDTO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    VehicleDAO vehicleDAO;

    public Booking addBooking(BookingDTO bookingDTO) throws Exception {
        Booking booking = new Booking();
        booking.setAmount(bookingDTO.getAmount());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setPickUpDate(bookingDTO.getPickupDate());
        booking.setDropOffDate(bookingDTO.getDropoffDate());
        booking.setBooking(userDAO.findById(bookingDTO.getUserId()).get());
        User user = userDAO.findById(bookingDTO.getUserId()).get();
        if (user.getWalletMoney() < bookingDTO.getAmount()) {
            throw new Exception("InSufficient Balance. Please Check With Admin.");
        } else {
            user.setWalletMoney(user.getWalletMoney() - bookingDTO.getAmount());
            userDAO.save(user);
        }
        booking.setLocation(locationDAO.findById(bookingDTO.getLocationId()).get());
        booking.setVehicle(vehicleDAO.findById(bookingDTO.getVehicleId()).get());
        return bookingDAO.save(booking);
    }


}
