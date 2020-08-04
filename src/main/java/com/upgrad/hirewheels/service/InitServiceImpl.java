package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {

    @Qualifier("roleDAO")
    @Autowired
    roleDAO roleDAO;

    @Qualifier("usersDAO")
    @Autowired
    usersDAO usersDAO;

    @Qualifier("vehicle_categoryDAO")
    @Autowired
    vehicle_categoryDAO vehicle_categoryDAO;

    @Qualifier("vehicle_subcategoryDAO")
    @Autowired
    vehicle_subcategoryDAO vehicle_subcategoryDAO;

    @Qualifier("cityDAO")
    @Autowired
    cityDAO cityDAO;

    @Qualifier("fuel_typeDAO")
    @Autowired
    fuel_typeDAO fuel_typeDAO;

    @Qualifier("vehicleDAO")
    @Autowired
    vehicleDAO vehicleDAO;

    @Qualifier("locationDAO")
    @Autowired
    locationDAO locationDAO;

    @Qualifier("bookingDAO")
    @Autowired
    bookingDAO bookingDAO;


    public void start() {
        addrole();
        addusers();
        addvehicle_category();
        addvehicle_subcategory();
        addcity();
        addfuel_type();
        addlocation();
    }

    private void addrole() {
        role adminUserRole = new role();
        adminUserRole.setRole_id(1);
        adminUserRole.setRole_name("Admin");
        role userRole = new role();
        userRole.setRole_id(2);
        userRole.setRole_name("User");
        roleDAO.save(adminUserRole);
        roleDAO.save(userRole);
    }

    private void addusers() {
        users adminUser = new users();
        adminUser.setFirst_name("Upgrad");
        adminUser.setLast_name("Admim");
        adminUser.setEmail("upgrad@gmail.com");
        adminUser.setMobile_no("9898989890");
        adminUser.setPassword("admin@123");
        adminUser.setWallet_money(10000);
        adminUser.setRole(roleDAO.findByrole_id(1));
        usersDAO.save(adminUser);
    }

    private void addvehicle_category() {
        List<vehicle_category> vehicleCategoryList = new ArrayList<>();

        vehicle_category vehicleCategory1 = new vehicle_category();
        vehicleCategory1.setVehicle_category_id(10);
        vehicleCategory1.setVehicle_category_name("CAR");
        vehicleCategoryList.add(vehicleCategory1);


        vehicle_category vehicleCategory2 = new vehicle_category();
        vehicleCategory2.setVehicle_category_id(11);
        vehicleCategory2.setVehicle_category_name("BIKE");
        vehicleCategoryList.add(vehicleCategory2);
        vehicle_categoryDAO.saveAll(vehicleCategoryList);
    }

    private void addvehicle_subcategory() {
        List<vehicle_subcategory> vehicleSubCategories = new ArrayList<>();


        vehicle_subcategory vehicleSubCategory1 = new vehicle_subcategory();
        vehicleSubCategory1.setVehicle_subcategory_id(1);
        vehicleSubCategory1.setVehicle_subcategory_name("SUV");
        vehicleSubCategory1.setPrice_per_day(300);
        vehicleSubCategory1.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategories.add(vehicleSubCategory1);


        vehicle_subcategory vehicleSubCategory2 = new vehicle_subcategory();
        vehicleSubCategory2.setVehicle_subcategory_id(2);
        vehicleSubCategory2.setVehicle_subcategory_name("SEDAN");
        vehicleSubCategory2.setPrice_per_day(350);
        vehicleSubCategory2.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategories.add(vehicleSubCategory2);


        vehicle_subcategory vehicleSubCategory3 = new vehicle_subcategory();
        vehicleSubCategory3.setVehicle_subcategory_id(3);
        vehicleSubCategory3.setVehicle_subcategory_name("HATCHBACK");
        vehicleSubCategory3.setPrice_per_day(250);
        vehicleSubCategory3.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategories.add(vehicleSubCategory3);


        vehicle_subcategory vehicleSubCategory4 = new vehicle_subcategory();
        vehicleSubCategory4.setVehicle_subcategory_id(4);
        vehicleSubCategory4.setVehicle_subcategory_name("CRUISER");
        vehicleSubCategory4.setPrice_per_day(200);
        vehicleSubCategory4.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategories.add(vehicleSubCategory4);


        vehicle_subcategory vehicleSubCategory5 = new vehicle_subcategory();
        vehicleSubCategory5.setVehicle_subcategory_id(5);
        vehicleSubCategory5.setVehicle_subcategory_name("DIRT BIKE");
        vehicleSubCategory5.setPrice_per_day(200);
        vehicleSubCategory5.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategories.add(vehicleSubCategory5);


        vehicle_subcategory vehicleSubCategory6 = new vehicle_subcategory();
        vehicleSubCategory6.setVehicle_subcategory_id(6);
        vehicleSubCategory6.setVehicle_subcategory_name("SPORTS BIKE");
        vehicleSubCategory6.setPrice_per_day(150);
        vehicleSubCategory6.setVehicleCategory(vehicle_categoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategories.add(vehicleSubCategory6);


        vehicle_subcategoryDAO.saveAll(vehicleSubCategories);
    }

    private void addcity() {
        city city = new city();
        city.setCity_id(1);
        city.setCity_name("Mumbai");
        cityDAO.save(city);
    }

    private void addfuel_type() {
        List<fuel_type> fuelTypeList = new ArrayList<>();
        fuel_type fuelType1 = new fuel_type();
        fuelType1.setFuel_type("Petrol");
        fuelType1.setFuel_type_id(1);
        fuelTypeList.add(fuelType1);
        fuel_type fuelType2 = new fuel_type();
        fuelType2.setFuel_type("Diesel");
        fuelType2.setFuel_type_id(2);
        fuelTypeList.add(fuelType2);
        fuel_typeDAO.saveAll(fuelTypeList);
    }

    private void addlocation() {
        location location = new location();
        location.setLocation_id(1);
        location.setLocation_name("Worli");
        location.setAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location.setPincode(400018);
        location.setCity(cityDAO.findById(1).get());
        locationDAO.save(location);

        location location2 = new location();
        location2.setLocation_id(2);
        location2.setLocation_name("Chembur");
        location2.setAddress("Oplic Complex");
        location2.setPincode(400018);
        location2.setCity(cityDAO.findById(1).get());
        locationDAO.save(location2);

        location location3 = new location();
        location3.setLocation_id(3);
        location3.setLocation_name("Powai");
        location3.setAddress("Hiranandani Tower");
        location3.setPincode(400018);
        location3.setCity(cityDAO.findById(1).get());
        locationDAO.save(location3);
    }













}
