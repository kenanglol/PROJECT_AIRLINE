package com.airplaneservice.service;

import com.airplaneservice.entity.Plane;
import java.util.List;
import java.util.Optional;

public interface PlaneService {
    List<Plane> getAllPlanes();
    Optional<Plane> getPlaneById(String planeNo);
    Plane createPlane(Plane plane);
    Optional<Plane> updatePlane(String planeNo, Plane plane);
    boolean deletePlane(String planeNo);
} 