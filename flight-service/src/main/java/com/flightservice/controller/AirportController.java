package com.flightservice.controller;

import com.flightservice.entity.Airport;
import com.flightservice.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {
    
    private final AirportService airportService;
    
    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }
    
    @GetMapping("/{code}")
    public ResponseEntity<Airport> getAirportByCode(@PathVariable String code) {
        return ResponseEntity.ok(airportService.getAirportByCode(code));
    }
    
    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.createAirport(airport));
    }
    
    @PutMapping("/{code}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String code, @RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.updateAirport(code, airport));
    }
    
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String code) {
        airportService.deleteAirport(code);
        return ResponseEntity.ok().build();
    }
} 