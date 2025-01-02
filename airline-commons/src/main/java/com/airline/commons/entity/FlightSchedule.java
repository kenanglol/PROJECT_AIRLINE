package com.airline.commons.entity;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FLIGHT_SCHEDULE")
public class FlightSchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "flight_schedule_seq", sequenceName = "flight_schedule_seq", allocationSize = 1)
    @Column(name = "SCHEDULE_ID")
    private Integer scheduleId;
    
    @Column(name = "DEPARTURE_PORT_CODE")
    private String departurePortCode;
    
    @Column(name = "LANDING_PORT_CODE")
    private String landingPortCode;
    
    private Integer averageFlightDuration;
} 