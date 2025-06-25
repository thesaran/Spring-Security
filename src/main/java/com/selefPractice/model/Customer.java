package com.selefPractice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false, length = 100)
    private String customerName;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 10)
    private String zipCode;

    @Column(length = 50)
    private String country;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name ="username" ,nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false, length = 255)
    private String password;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private LocalDateTime accountCreationDate;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private int loyaltyPoints;

    @Enumerated(EnumType.STRING)
    private PreferredContactMethod preferredContactMethod;

    private boolean marketingOptIn;

    @Column(name = "customer_type" , length = 50)
    private String customerType;

    @Column(name = "customer_access" , length = 50)
    private String customerAccess;


    @Column(length = 20)
    private String referralCode;

    // Getters and Setters

    public enum Gender {
        Male, Female, OTHER
    }

    public enum AccountStatus {
        Active, INACTIVE, SUSPENDED
    }

    public enum PreferredContactMethod {
        Email, Phone, SMS
    }

    // Constructors, getters, setters, toString(), etc.

    // Example constructor
    public Customer() {
        this.accountCreationDate = LocalDateTime.now();
        this.accountStatus = AccountStatus.Active;
    }

    // Other constructors, getters and setters
}