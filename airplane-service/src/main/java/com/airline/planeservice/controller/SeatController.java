package com.airline.planeservice.controller;

import com.airline.commons.entity.Seat;
import com.airline.planeservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    
    private final SeatService seatService;
    
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }
    
    @GetMapping("/{seatNo}")
    public ResponseEntity<Seat> getSeatById(@PathVariable String seatNo) {
        return seatService.getSeatById(seatNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/plane/{planeNo}/active")
    public List<Seat> getAllActiveSeatsByPlaneNo(@PathVariable String planeNo) {
        return seatService.getAllActiveSeatsByPlaneNo(planeNo);
    }
    
    @GetMapping("/plane/{planeNo}")
    public List<Seat> getAllSeatsByPlaneNo(@PathVariable String planeNo) {
        return seatService.getAllSeatsByPlaneNo(planeNo);
    }
    
    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.createSeat(seat));
    }
    
    @PutMapping("/{seatNo}")
    public ResponseEntity<Seat> updateSeat(@PathVariable String seatNo, @RequestBody Seat seat) {
        return seatService.updateSeat(seatNo, seat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{seatNo}")
    public ResponseEntity<Void> deleteSeat(@PathVariable String seatNo) {
        return seatService.deleteSeat(seatNo)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
} 