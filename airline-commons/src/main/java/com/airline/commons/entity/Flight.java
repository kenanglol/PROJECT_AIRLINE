package com.airline.commons.entity;

import jakarta.persistence.*;
import com.airline.commons.enums.FlightStatus;
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
    private Integer scheduleId;
    
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