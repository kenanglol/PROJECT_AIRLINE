package com.airline.flightservice.service;

import com.airline.commons.entity.FlightSchedule;
import com.airline.flightservice.repository.FlightScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightScheduleService {
    
    private final FlightScheduleRepository flightScheduleRepository;
    
    public List<FlightSchedule> getAllSchedules() {
        return flightScheduleRepository.findAll();
    }
    
    public FlightSchedule getScheduleById(Integer id) {
        return flightScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight schedule not found"));
    }
    
    public FlightSchedule createSchedule(FlightSchedule schedule) {
        return flightScheduleRepository.save(schedule);
    }
    
    public FlightSchedule updateSchedule(Integer id, FlightSchedule schedule) {
        if (!flightScheduleRepository.existsById(id)) {
            throw new RuntimeException("Flight schedule not found");
        }
        schedule.setScheduleId(id);
        return flightScheduleRepository.save(schedule);
    }
    
    public void deleteSchedule(Integer id) {
        flightScheduleRepository.deleteById(id);
    }
} 