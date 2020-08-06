package com.upgrad.hirewheels.service;


import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;
    @Autowired
    VehicleCategoryDAO vehicleCategoryDAO;
    @Autowired
    BookingDAO bookingDAO;
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    FuelTypeDAO fuelTypeDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    UserDAO userDAO;

    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate,Date dropDate, int locationId) {
        List<Vehicle> vehicle_List = new ArrayList<>();
        return vehicle_List;
    }



    public List<Vehicle> getAllVehicleByUserId(int userId) throws Exception {
        List<Vehicle> vehicle = new ArrayList<>();
        List<Vehicle> vehicle_list;
        if (userId != 1){
            vehicle_list = userDAO.findById(userId).get().getVehicle();
        } else {
            vehicle_list = vehicleDAO.findAll();
        }
        for (Vehicle v: vehicle_list){
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setVehicleId(v.getVehicleId());
            vehicle1.setVehicleNumber(v.getVehicleNumber());
            vehicle1.setColor(v.getColor());
            vehicle1.setCarImageUrl(v.getCarImageUrl());
            vehicle.add(vehicle1);
        }
        return vehicle;
    }

}

