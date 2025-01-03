package com.airline.flightservice.repository;

import com.airline.commons.entity.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> {
} 