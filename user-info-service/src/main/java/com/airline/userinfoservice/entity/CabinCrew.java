package com.airline.userinfoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CABIN_CREW")
@NoArgsConstructor
@AllArgsConstructor
public class CabinCrew {
    
    @EmbeddedId
    private CabinCrewId id;
} 