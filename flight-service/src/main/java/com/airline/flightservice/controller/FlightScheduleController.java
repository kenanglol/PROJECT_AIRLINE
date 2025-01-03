package com.airline.flightservice.controller;

import com.airline.commons.entity.FlightSchedule;
import com.airline.flightservice.service.FlightScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class FlightScheduleController {
    
    private final FlightScheduleService flightScheduleService;
    
    @GetMapping
    public ResponseEntity<List<FlightSchedule>> getAllSchedules() {
        return ResponseEntity.ok(flightScheduleService.getAllSchedules());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FlightSchedule> getScheduleById(@PathVariable Integer id) {
        return ResponseEntity.ok(flightScheduleService.getScheduleById(id));
    }
    
    @PostMapping
    public ResponseEntity<FlightSchedule> createSchedule(@RequestBody FlightSchedule schedule) {
        return ResponseEntity.ok(flightScheduleService.createSchedule(schedule));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FlightSchedule> updateSchedule(@PathVariable Integer id, @RequestBody FlightSchedule schedule) {
        return ResponseEntity.ok(flightScheduleService.updateSchedule(id, schedule));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        flightScheduleService.deleteSchedule(id);
        return ResponseEntity.ok().build();
    }
} 