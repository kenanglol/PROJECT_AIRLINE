package com.airline.planeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    
    @NotBlank(message = "Uçuş numarası boş olamaz")
    private String flightNo;
    
    @NotNull(message = "Koltuk numarası boş olamaz")
    private String planeSeatId;
    
    @NotBlank(message = "Yolcu id boş olamaz")
    private String passengerId;
    
    @NotNull(message = "Bilet fiyatı boş olamaz")
    @Positive(message = "Bilet fiyatı pozitif bir sayı olmalıdır")
    private Double price;

    @Builder.Default
    private Boolean hasInFlightEntertainment = false;

    @Builder.Default 
    private Integer baggageCapInPlane = 8;

    @Builder.Default
    private Integer baggageCapUnderPlane = 15;

    @Builder.Default
    private Boolean hasFoodService = false;
} 