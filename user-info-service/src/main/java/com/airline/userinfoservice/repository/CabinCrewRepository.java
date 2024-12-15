package com.airline.userinfoservice.repository;

import com.airline.userinfoservice.entity.CabinCrew;
import com.airline.userinfoservice.entity.CabinCrewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinCrewRepository extends JpaRepository<CabinCrew, CabinCrewId> {
    List<CabinCrew> findByIdFlightNo(String flightNo);
    List<CabinCrew> findByIdStaffId(Long staffId);
} 