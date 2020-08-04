package com.upgrad.hirewheels.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name= "FuelType")
public class FuelType {
        @Id
        int fuelTypeId;
        @Column( nullable = false)
        String fuelType;
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuelType")
        List<Vehicle> vehicles;
}

