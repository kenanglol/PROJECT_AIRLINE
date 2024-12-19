package com.airline.flightservice.repository;

import com.airline.flightservice.entity.Flight;
import com.airline.flightservice.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByStatus(FlightStatus status);
    List<Flight> findByPlaneNo(String planeNo);
    boolean existsByFlightNo(String flightNo);
} 