package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Vehicle")
public class Vehicle {
   @Id
   @GeneratedValue
   int vehicleId;
   @Column(nullable = false)
   String vehicleModel;
   @Column(nullable = false, unique = true)
   String vehicleNumber;
   @Column(nullable = false)
   String color;
   @Column(nullable = false)
   String carImageUrl;
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
   @JoinColumn(name = "vehicleSubCategoryId")
   VehicleSubCategory vehicleSubCategory;
   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "fuelTypeId")
   FuelType fuelType;
   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "locationId")
   Location location;
   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JoinColumn(name = "userId")
   User user;
   @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.MERGE)
   List<Booking> bookings;
}
