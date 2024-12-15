package com.airline.userinfoservice.service.impl;

import com.airline.userinfoservice.client.FlightClient;
import com.airline.userinfoservice.entity.CabinCrew;
import com.airline.userinfoservice.entity.CabinCrewId;
import com.airline.userinfoservice.entity.Flight;
import com.airline.userinfoservice.exception.ResourceNotFoundException;
import com.airline.userinfoservice.repository.CabinCrewRepository;
import com.airline.userinfoservice.repository.StaffRepository;
import com.airline.userinfoservice.service.CabinCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CabinCrewServiceImpl implements CabinCrewService {

    private final CabinCrewRepository cabinCrewRepository;
    private final FlightClient flightClient;
    private final StaffRepository staffRepository;

    @Override
    public CabinCrew assignStaff(String flightNo, Long staffId) {
        Flight flight = validateFlight(flightNo);
        validateStaff(staffId);
        checkForConflictingAssignments(flight, staffId);

        CabinCrew cabinCrew = new CabinCrew(new CabinCrewId(flightNo, staffId));
        return cabinCrewRepository.save(cabinCrew);
    }

    private Flight validateFlight(String flightNo) {
        Flight flight = flightClient.getFlightByNo(flightNo);
        if (flight == null) {
            throw new ResourceNotFoundException("Flight not found with number: " + flightNo);
        }
        return flight;
    }

    private void validateStaff(Long staffId) {
        if (!staffRepository.existsById(staffId)) {
            throw new ResourceNotFoundException("Staff not found with id: " + staffId);
        }
    }

    private void checkForConflictingAssignments(Flight flight, Long staffId) {
        List<CabinCrew> staffAssignments = cabinCrewRepository.findByIdStaffId(staffId);
        for (CabinCrew assignment : staffAssignments) {
            Flight assignedFlight = flightClient.getFlightByNo(assignment.getId().getFlightNo());
            if (isTimeConflict(flight, assignedFlight)) {
                throw new RuntimeException("Staff is already assigned to another flight during these hours");
            }
        }
    }

    private boolean isTimeConflict(Flight flight1, Flight flight2) {
        return (flight1.getDepartureTime().isBefore(flight2.getLandingTime()) && 
                flight1.getLandingTime().isAfter(flight2.getDepartureTime()));
    }

    @Override
    public void dismissStaff(String flightNo, Long staffId) {
        CabinCrewId id = new CabinCrewId(flightNo, staffId);
        if (!cabinCrewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cabin crew assignment not found");
        }
        cabinCrewRepository.deleteById(id);
    }

    @Override
    public List<CabinCrew> searchWithFlight(String flightNo) {
        return cabinCrewRepository.findByIdFlightNo(flightNo);
    }

    @Override
    public List<CabinCrew> searchWithStaff(Long staffId) {
        return cabinCrewRepository.findByIdStaffId(staffId);
    }
} 