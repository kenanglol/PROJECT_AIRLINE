package com.airline.userinfoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER_INFO")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    
    @Column(name = "SURNAME")
    private String surname;
    
    @Column(name = "C_NUMBER")
    private String cNumber;
    
    @Column(name = "PASSPORT_NO")
    private String passportNo;
    
    @Column(name = "SEX")
    private String sex;
    
    @Column(name = "MAIL")
    private String mail;
    
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    
    @Column(name = "NATIONALITY")
    private String nationality;
} 