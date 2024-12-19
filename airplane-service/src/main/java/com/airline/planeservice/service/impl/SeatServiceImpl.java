package com.airline.planeservice.service.impl;

import com.airline.planeservice.entity.Seat;
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
    public Optional<Seat> getSeatById(Long seatId) {
        return seatRepository.findById(seatId);
    }
    
    @Override
    public List<Seat> getSeatsByPlaneNo(String planeNo) {
        return seatRepository.findByPlaneNo(planeNo);
    }
    
    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }
    
    @Override
    public Optional<Seat> updateSeat(Long seatId, Seat seat) {
        if (!seatRepository.existsById(seatId)) {
            return Optional.empty();
        }
        seat.setPlaneSeatId(seatId);
        return Optional.of(seatRepository.save(seat));
    }
    
    @Override
    public boolean deleteSeat(Long seatId) {
        if (!seatRepository.existsById(seatId)) {
            return false;
        }
        seatRepository.deleteById(seatId);
        return true;
    }
} 