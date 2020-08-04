package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Location")
public class Location {
    @Id
    int locationId;
    @Column( nullable = false)
    String locationName;
    @Column( nullable = false)
    String address;
    @Column( nullable = false)
    int pincode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location",cascade = CascadeType.ALL)
    List<Vehicle> vehicles;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    City city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location",cascade = CascadeType.MERGE)
    List<Booking> bookings;
}
