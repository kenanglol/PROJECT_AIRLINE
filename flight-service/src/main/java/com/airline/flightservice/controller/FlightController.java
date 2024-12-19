package com.airline.flightservice.controller;

import com.airline.flightservice.entity.Flight;
import com.airline.flightservice.service.FlightService;
import com.airline.flightservice.enums.FlightStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.createFlight(flight));
    }
    
    @PutMapping("/{flightNo}/cancel")
    public ResponseEntity<Flight> cancelFlight(@PathVariable String flightNo) {
        return ResponseEntity.ok(flightService.cancelFlight(flightNo));
    }
    
    @PutMapping("/{flightNo}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String flightNo, @RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.updateFlight(flightNo, flight));
    }
    
    @GetMapping("/{flightNo}")
    public ResponseEntity<Flight> getFlight(@PathVariable String flightNo) {
        return ResponseEntity.ok(flightService.getFlight(flightNo));
    }
    
    @GetMapping
    public ResponseEntity<List<Flight>> getFlights(
            @RequestParam(required = false) FlightStatus status,
            @RequestParam(required = false) String planeNo) {
        return ResponseEntity.ok(flightService.getFlights(status, planeNo));
    }
    
    @GetMapping("/{flightNo}/exists")
    public ResponseEntity<Boolean> existsFlight(@PathVariable String flightNo) {
        return ResponseEntity.ok(flightService.existsFlight(flightNo));
    }
}