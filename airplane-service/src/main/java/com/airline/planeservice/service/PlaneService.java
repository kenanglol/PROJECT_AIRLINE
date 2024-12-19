package com.airline.planeservice.service;

import com.airline.planeservice.entity.Plane;
import java.util.List;
import java.util.Optional;

public interface PlaneService {
    List<Plane> getAllPlanes();
    Optional<Plane> getPlaneById(String planeNo);
    Plane createPlane(Plane plane);
    Optional<Plane> updatePlane(String planeNo, Plane plane);
    boolean deletePlane(String planeNo);
} 