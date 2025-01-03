package com.airline.planeservice.service.impl;

import com.airline.commons.entity.Seat;
import com.airline.planeservice.repository.SeatRepository;
import com.airline.planeservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    
    private final SeatRepository seatRepository;
    
    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
    
    @Override
    public Optional<Seat> getSeatById(String seatNo) {
        return seatRepository.findById(seatNo);
    }
    
    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }
    
    @Override
    public Optional<Seat> updateSeat(String seatNo, Seat seat) {
        if (!seatRepository.existsById(seatNo)) {
            return Optional.empty();
        }
        seat.setSeatNo(seatNo);
        return Optional.of(seatRepository.save(seat));
    }
    
    @Override
    public boolean deleteSeat(String seatNo) {
        if (!seatRepository.existsById(seatNo)) {
            return false;
        }
        seatRepository.deleteById(seatNo);
        return true;
    }
    
    @Override
    public List<Seat> getAllActiveSeatsByPlaneNo(String planeNo) {
        return seatRepository.findByPlaneNoAndActive(planeNo, true);
    }
    
    @Override
    public List<Seat> getAllSeatsByPlaneNo(String planeNo) {
        return seatRepository.findByPlaneNo(planeNo);
    }
} 