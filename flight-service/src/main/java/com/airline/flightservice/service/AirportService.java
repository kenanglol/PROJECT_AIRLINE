package com.airline.flightservice.service;

import com.airline.commons.entity.Airport;
import com.airline.flightservice.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    
    private final AirportRepository airportRepository;
    
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
    
    public Airport getAirportByCode(String code) {
        return airportRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }
    
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }
    
    public Airport updateAirport(String code, Airport airport) {
        if (!airportRepository.existsById(code)) {
            throw new RuntimeException("Airport not found");
        }
        airport.setCode(code);
        return airportRepository.save(airport);
    }
    
    public void deleteAirport(String code) {
        airportRepository.deleteById(code);
    }
} 