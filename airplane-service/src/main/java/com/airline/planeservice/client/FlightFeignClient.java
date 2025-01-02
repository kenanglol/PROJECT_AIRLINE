package com.airline.planeservice.client;

import com.airline.commons.entity.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "flight-service", fallback = FlightFeignClientFallback.class)
public interface FlightFeignClient {
    
    @GetMapping("/api/v1/flights/{flightNo}")
    Flight getFlightByFlightNo(@PathVariable("flightNo") String flightNo);
} 