package com.airline.planeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.airline.planeservice.entity.Seat;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    List<Seat> findByPlaneNo(String planeNo);
    List<Seat> findByPlaneNoAndIsActive(String planeNo, Boolean isActive);
} 