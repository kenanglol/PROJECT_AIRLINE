package com.flightservice.service;

import com.flightservice.entity.Flight;
import com.flightservice.entity.FlightSchedule;
import com.flightservice.enums.FlightStatus;
import com.flightservice.repository.FlightRepository;
import com.flightservice.repository.FlightScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightScheduleRepository flightScheduleRepository;
    
    public Flight createFlight(Flight flight) {
        FlightSchedule schedule = flightScheduleRepository.findById(flight.getScheduleId())
            .orElseThrow(() -> new RuntimeException("Flight Schedule not found with id: " + flight.getScheduleId()));
            
        flight.setStatus(FlightStatus.SCHEDULED);
        return flightRepository.save(flight);
    }
    
    public Flight cancelFlight(String flightNo) {
        Flight flight = getFlight(flightNo);
        flight.setStatus(FlightStatus.CANCELED);
        return flightRepository.save(flight);
    }
    
    public Flight updateFlight(String id, Flight flight) {
        if (!flightRepository.existsById(id)) {
            throw new RuntimeException("Flight not found with id: " + id);
        }
        
        flightScheduleRepository.findById(flight.getScheduleId())
            .orElseThrow(() -> new RuntimeException("Flight Schedule not found with id: " + flight.getScheduleId()));
            
        flight.setFlightNo(id);
        return flightRepository.save(flight);
    }
    
    public Flight getFlight(String flightNo) {
        return flightRepository.findById(flightNo)
                .orElseThrow(() -> new RuntimeException("Uçuş bulunamadı"));
    }
    
    public List<Flight> getFlights(FlightStatus status, String planeNo) {
        if (status != null) {
            return flightRepository.findByStatus(status);
        }
        if (planeNo != null) {
            return flightRepository.findByPlaneNo(planeNo);
        }
        return flightRepository.findAll();
    }
    
    public boolean existsFlight(String flightNo) {
        return flightRepository.existsByFlightNo(flightNo);
    }
} 