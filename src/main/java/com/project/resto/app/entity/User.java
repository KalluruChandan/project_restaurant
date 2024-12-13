package com.project.resto.app.entity;

import com.project.resto.app.util.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;
    @Enumerated(EnumType.STRING)
    private Status status;
}