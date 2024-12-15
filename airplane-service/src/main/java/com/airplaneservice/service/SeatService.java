package com.airplaneservice.service;

import com.airplaneservice.entity.Seat;
import java.util.List;
import java.util.Optional;

public interface SeatService {
    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(Long seatId);
    List<Seat> getSeatsByPlaneNo(String planeNo);
    Seat createSeat(Seat seat);
    Optional<Seat> updateSeat(Long seatId, Seat seat);
    boolean deleteSeat(Long seatId);
} 