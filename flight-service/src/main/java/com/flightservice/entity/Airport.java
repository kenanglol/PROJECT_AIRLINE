package com.flightservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "AIRPORT")
public class Airport {

    @Id
    @Column(name = "CODE", length = 3)
    private String code;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "COUNTRY")
    private String country;
} 