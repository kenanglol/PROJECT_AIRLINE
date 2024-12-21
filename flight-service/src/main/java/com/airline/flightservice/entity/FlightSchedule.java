package com.airline.flightservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
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