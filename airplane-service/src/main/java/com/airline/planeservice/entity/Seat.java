package com.airline.planeservice.entity;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANE_SEAT_ID")
    private Long planeSeatId;
    
    @Column(name = "ACTIVE")
    private Boolean active;
    
    @Column(name = "PLANE_NO")
    private String planeNo;
    
    @Column(name = "SEAT_ROW")
    private Integer seatRow;
    
    @Column(name = "SEAT_LETTER")
    private String seatLetter;
    
    @Column(name = "IS_WINDOW_SIDE")
    private Boolean isWindowSide;
    
    @Column(name = "IS_EMERGENCY_EXIT")
    private Boolean isEmergencyExit;
}