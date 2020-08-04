package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue
    int bookingId;
    @Column( nullable = false)
    Date pickUpDate;
    @Column( nullable = false)
    Date dropOffDate;
    @Column( nullable = false)
    Date bookingDate;
    @Column( nullable = false)
    int amount;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    User booking;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "locationId")
    Location location;
    @ManyToOne(fetch = FetchType.LAZY,cascade
            = CascadeType.MERGE)
    @JoinColumn(name = "vehicleId")
    Vehicle vehicle;
}
