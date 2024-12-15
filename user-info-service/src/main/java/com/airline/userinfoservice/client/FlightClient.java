package com.airline.userinfoservice.client;

import com.airline.userinfoservice.config.FeignConfig;
import com.airline.userinfoservice.entity.Flight;
import com.airline.userinfoservice.enums.FlightStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "flight-service", url = "${flight.service.url}", configuration = FeignConfig.class)
public interface FlightClient {
    
    @PostMapping("/api/flights")
    Flight createFlight(@RequestBody Flight flight);
    
    @PutMapping("/api/flights/{flightNo}/cancel")
    Flight cancelFlight(@PathVariable("flightNo") String flightNo);
    
    @PutMapping("/api/flights/{flightNo}")
    Flight updateFlight(@PathVariable("flightNo") String flightNo, @RequestBody Flight flight);
    
    @GetMapping("/api/flights/{flightNo}")
    Flight getFlightByNo(@PathVariable("flightNo") String flightNo);
    
    @GetMapping("/api/flights")
    List<Flight> getFlights(@RequestParam(value = "status", required = false) FlightStatus status,
                           @RequestParam(value = "planeNo", required = false) String planeNo);
    
    @GetMapping("/api/flights/{flightNo}/exists")
    boolean existsById(@PathVariable("flightNo") String flightNo);
} 