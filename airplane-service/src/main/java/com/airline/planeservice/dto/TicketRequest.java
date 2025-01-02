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
    @Positive(message = "Koltuk numarası pozitif bir sayı olmalıdır")
    private Integer planeSeatId;
    
    @NotBlank(message = "Yolcu adı boş olamaz")
    private String passengerName;
    
    @NotNull(message = "Bilet fiyatı boş olamaz")
    @Positive(message = "Bilet fiyatı pozitif bir sayı olmalıdır")
    private Double price;
} 