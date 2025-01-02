package com.airline.planeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private String ticketId;
    private String flightNo;
    private Integer planeSeatId;
    private String passengerName;
    private Double price;
} 