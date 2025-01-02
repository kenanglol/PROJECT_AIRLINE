package com.airline.planeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.commons.entity.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {
} 