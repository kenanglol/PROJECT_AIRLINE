package com.airline.flightservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import com.airline.flightservice.enums.FlightStatus;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "flight_seq", allocationSize = 1)
    @Column(name = "FLIGHT_NO")
    private String flightNo;
    
    @Column(name = "SCHEDULE_ID")
    private String scheduleId;
    
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

    @Column(name = "BOARDING_GATE")
    private Integer boardingGate;
} 