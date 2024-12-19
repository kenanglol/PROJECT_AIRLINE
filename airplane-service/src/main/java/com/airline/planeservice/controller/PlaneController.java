package com.airline.planeservice.controller;

import com.airline.planeservice.entity.Plane;
import com.airline.planeservice.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class PlaneController {
    
    private final PlaneService planeService;
    
    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }
    
    @GetMapping("/{planeNo}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable String planeNo) {
        return planeService.getPlaneById(planeNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.createPlane(plane));
    }
    
    @PutMapping("/{planeNo}")
    public ResponseEntity<Plane> updatePlane(@PathVariable String planeNo, @RequestBody Plane plane) {
        return planeService.updatePlane(planeNo, plane)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{planeNo}")
    public ResponseEntity<Void> deletePlane(@PathVariable String planeNo) {
        return planeService.deletePlane(planeNo)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
} 