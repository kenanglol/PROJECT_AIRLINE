package com.flightservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import com.flightservice.enums.FlightStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "FLIGHT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @Column(name = "FLIGHT_NO")
    private String flightNo;
    
    @Column(name = "SCHEDULE")
    private LocalDateTime schedule;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private FlightStatus status;
    
    @Column(name = "PLANE_NO")
    private String planeNo;
    
    @Column(name = "DEPARTURE_TIME")
    private LocalDateTime departureTime;
    
    @Column(name = "ESTIMATED_DEPARTURE_TIME")
    private LocalDateTime estimatedDepartureTime;
    
    @Column(name = "LANDING_TIME")
    private LocalDateTime landingTime;
    
    @Column(name = "DELAY")
    private Integer delay;
} 