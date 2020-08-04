package com.upgrad.hirewheels.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="UserRole")
public class UserRole {
    @Id
    int roleId;
    @Column(unique = true)
    String roleName;
    @OneToMany(fetch = FetchType.LAZY)
    List<User> users;
}
