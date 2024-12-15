package com.airline.userinfoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CabinCrewId implements Serializable {
    
    @Column(name = "FLIGHT_NO")
    private String flightNo;
    
    @Column(name = "STAFF_ID")
    private Long staffId;
} 