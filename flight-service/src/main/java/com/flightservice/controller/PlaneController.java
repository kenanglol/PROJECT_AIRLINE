package com.flightservice.controller;

import com.flightservice.entity.Plane;
import com.flightservice.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class PlaneController {
    private final PlaneService planeService;
    
    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.createPlane(plane));
    }
    
    @GetMapping("/{planeNo}")
    public ResponseEntity<Plane> getPlane(@PathVariable String planeNo) {
        return ResponseEntity.ok(planeService.getPlane(planeNo));
    }
    
    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes() {
        return ResponseEntity.ok(planeService.getAllPlanes());
    }
    
    @PutMapping("/{planeNo}")
    public ResponseEntity<Plane> updatePlane(@PathVariable String planeNo, @RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.updatePlane(planeNo, plane));
    }
    
    @DeleteMapping("/{planeNo}")
    public ResponseEntity<Void> deletePlane(@PathVariable String planeNo) {
        planeService.deletePlane(planeNo);
        return ResponseEntity.ok().build();
    }
} 