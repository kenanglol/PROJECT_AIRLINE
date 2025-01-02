package com.airline.planeservice.service.impl;

import com.airline.commons.entity.Plane;
import com.airline.planeservice.repository.PlaneRepository;
import com.airline.planeservice.service.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService {
    
    private final PlaneRepository planeRepository;
    
    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }
    
    @Override
    public Optional<Plane> getPlaneById(String planeNo) {
        return planeRepository.findById(planeNo);
    }
    
    @Override
    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }
    
    @Override
    public Optional<Plane> updatePlane(String planeNo, Plane plane) {
        if (!planeRepository.existsById(planeNo)) {
            return Optional.empty();
        }
        plane.setPlaneNo(planeNo);
        return Optional.of(planeRepository.save(plane));
    }
    
    @Override
    public boolean deletePlane(String planeNo) {
        if (!planeRepository.existsById(planeNo)) {
            return false;
        }
        planeRepository.deleteById(planeNo);
        return true;
    }
} 