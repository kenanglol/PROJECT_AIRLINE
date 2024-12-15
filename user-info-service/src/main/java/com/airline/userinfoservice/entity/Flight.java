package com.airline.userinfoservice.entity;

import lombok.Data;
import com.airline.userinfoservice.enums.FlightStatus;
import java.time.LocalDateTime;

@Data
public class Flight {
    private String flightNo;
    private LocalDateTime schedule;
    private FlightStatus status;
    private String planeNo;
    private LocalDateTime departureTime;
    private LocalDateTime estimatedDepartureTime;
    private LocalDateTime landingTime;
    private Integer delay;
} 