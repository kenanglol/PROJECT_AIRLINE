package com.airline.planeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TICKET")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    
    @Id
    @Column(name = "TICKET_ID", length = 20, nullable = false)
    private String ticketId;
    
    @Column(name = "FLIGHT_NO", length = 20)
    private String flightNo;
    
    @Column(name = "PLANE_SEAT_NO", length = 20)
    private String planeSeatId;
    
    @Column(name = "USER_ID")
    private Integer userId;
    
    @Column(name = "HAS_IN_FLIGHT_ENTERTAINMENT")
    private Boolean hasInFlightEntertainment;;
    
    @Column(name = "BAGGAGE_CAP_IN_PLANE")
    private Integer baggageCapInPlane;
    
    @Column(name = "BAGGAGE_CAP_UNDER_PLANE")
    private Integer baggageCapUnderPlane;
    
    @Column(name = "HAS_FOOD_SERVICE")
    private Boolean hasFoodService;;
} 