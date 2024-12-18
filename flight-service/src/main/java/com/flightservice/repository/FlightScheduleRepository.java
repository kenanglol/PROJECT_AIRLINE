package com.flightservice.repository;

import com.flightservice.entity.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, String> {
} 