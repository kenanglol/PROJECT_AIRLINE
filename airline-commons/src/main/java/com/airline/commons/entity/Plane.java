package com.airline.commons.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLANE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @Column(name = "PLANE_NO")
    private String planeNo;
    
    @Column(name = "PLANE_NAME")
    private String planeName;
    
    @Column(name = "MODEL")
    private String model;
    
    @Column(name = "CLASS")
    private String planeClass;
    
    @Column(name = "CAPACITY")
    private Integer capacity;
    
    @Column(name = "PRODUCTION_DATE")
    private LocalDate productionDate;
} 