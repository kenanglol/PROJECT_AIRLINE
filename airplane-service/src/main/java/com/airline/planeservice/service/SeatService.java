package com.airline.planeservice.service;

import com.airline.commons.entity.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(String seatNo);
    Seat createSeat(Seat seat);
    Optional<Seat> updateSeat(String seatNo, Seat seat);
    boolean deleteSeat(String seatNo);
    List<Seat> getAllActiveSeatsByPlaneNo(String planeNo);
    List<Seat> getAllSeatsByPlaneNo(String planeNo);
} 