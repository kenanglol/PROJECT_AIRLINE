package com.airplaneservice.controller;

import com.airplaneservice.entity.Seat;
import com.airplaneservice.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class PlaneSeatController {
    
    private final SeatService seatService;
    
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }
    
    @GetMapping("/{seatId}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long seatId) {
        return seatService.getSeatById(seatId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/plane/{planeNo}")
    public List<Seat> getSeatsByPlaneNo(@PathVariable String planeNo) {
        return seatService.getSeatsByPlaneNo(planeNo);
    }
    
    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.createSeat(seat));
    }
    
    @PutMapping("/{seatId}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long seatId, @RequestBody Seat seat) {
        return seatService.updateSeat(seatId, seat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long seatId) {
        return seatService.deleteSeat(seatId)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
} 