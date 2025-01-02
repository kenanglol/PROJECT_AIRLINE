package com.airline.planeservice.client;

import com.airline.commons.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightFeignClientFallback implements FlightFeignClient {
    
    @Override
    public Flight getFlightByFlightNo(String flightNo) {
        return null;
    }
} 