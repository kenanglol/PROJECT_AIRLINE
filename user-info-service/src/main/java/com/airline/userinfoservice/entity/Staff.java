package com.airline.userinfoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "STAFF")
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID")
    private Long staffId;
    
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
    
    @Column(name = "JOB")
    private String job;
    
    @Column(name = "AGE")
    private Integer age;
    
    @Column(name = "BEFORE_EXPERIENCE")
    private Integer beforeExperience;
    
    @Column(name = "START_DATE")
    private LocalDate startDate;
} 