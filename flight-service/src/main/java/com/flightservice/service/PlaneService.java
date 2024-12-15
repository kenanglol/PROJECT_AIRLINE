package com.flightservice.service;

import com.flightservice.entity.Plane;
import com.flightservice.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository planeRepository;
    
    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }
    
    public Plane getPlane(String planeNo) {
        return planeRepository.findById(planeNo)
                .orElseThrow(() -> new RuntimeException("Uçak bulunamadı"));
    }
    
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }
    
    public Plane updatePlane(String planeNo, Plane plane) {
        getPlane(planeNo); // kontrol için
        plane.setPlaneNo(planeNo);
        return planeRepository.save(plane);
    }
    
    public void deletePlane(String planeNo) {
        planeRepository.deleteById(planeNo);
    }
} 