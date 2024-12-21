package com.airline.planeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SEAT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    
    @Id
    @Column(name = "SEAT_NO", length = 20)
    private String seatNo;
    
    @Column(name = "ACTIVE", nullable = false)
    private Boolean active = true;
    
    @Column(name = "PLANE_NO", length = 20, nullable = false)
    private String planeNo;
    
    @Column(name = "SEAT_ROW", nullable = false)
    private Integer seatRow;
    
    @Column(name = "SEAT_LETTER", length = 1, nullable = false)
    private String seatLetter;
    
    @Column(name = "IS_WINDOW_SIDE", nullable = false)
    private Boolean isWindowSide = false;
    
    @Column(name = "IS_EMERGENCY_EXIT", nullable = false)
    private Boolean isEmergencyExit = false;
    
    @Column(name = "SEAT_ID", nullable = false)
    private Long seatId;
} 