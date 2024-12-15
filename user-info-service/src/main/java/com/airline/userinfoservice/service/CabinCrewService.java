package com.airline.userinfoservice.service;

import com.airline.userinfoservice.entity.CabinCrew;
import java.util.List;

public interface CabinCrewService {
    CabinCrew assignStaff(String flightNo, Long staffId);
    void dismissStaff(String flightNo, Long staffId);
    List<CabinCrew> searchWithFlight(String flightNo);
    List<CabinCrew> searchWithStaff(Long staffId);
} 