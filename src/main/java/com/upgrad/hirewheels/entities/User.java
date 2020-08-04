package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    int userId;
    @Column(nullable = false)
    String firstName;
    String lastName;
    @Column( nullable = false)
    String password;
    @Column( nullable = false, unique = true)
    String email;
    @Column( nullable = false, unique = true)
    String mobileNo;
    int walletMoney;
    @ManyToOne(fetch = FetchType.LAZY)
    UserRole userRole;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Vehicle> vehicle;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    List<Booking> bookings;
}
