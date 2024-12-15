package com.airline.userinfoservice.controller;

import com.airline.userinfoservice.entity.CabinCrew;
import com.airline.userinfoservice.service.CabinCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabin-crew")
@RequiredArgsConstructor
public class CabinCrewController {

    private final CabinCrewService cabinCrewService;

    @PostMapping("/assign")
    public ResponseEntity<CabinCrew> assignStaff(
            @RequestParam String flightNo,
            @RequestParam Long staffId) {
        return ResponseEntity.ok(cabinCrewService.assignStaff(flightNo, staffId));
    }

    @DeleteMapping("/dismiss")
    public ResponseEntity<Void> dismissStaff(
            @RequestParam String flightNo,
            @RequestParam Long staffId) {
        cabinCrewService.dismissStaff(flightNo, staffId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/flight/{flightNo}")
    public ResponseEntity<List<CabinCrew>> searchWithFlight(@PathVariable String flightNo) {
        return ResponseEntity.ok(cabinCrewService.searchWithFlight(flightNo));
    }

    @GetMapping("/search/staff/{staffId}")
    public ResponseEntity<List<CabinCrew>> searchWithStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(cabinCrewService.searchWithStaff(staffId));
    }
} 