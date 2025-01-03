package com.airline.planeservice.controller;

import com.airline.commons.entity.Ticket;
import com.airline.planeservice.dto.TicketRequest;
import com.airline.planeservice.dto.TicketResponse;
import com.airline.planeservice.service.TicketService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    
    private final TicketService ticketService;
    
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
    
    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String ticketId) {
        return ticketService.getTicketById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/flight/{flightNo}")
    public ResponseEntity<List<Ticket>> getTicketsByFlightNo(@PathVariable String flightNo) {
        return ResponseEntity.ok(ticketService.getTicketsByFlightNo(flightNo));
    }
    
    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        return new ResponseEntity<>(ticketService.createTicket(ticketRequest), HttpStatus.CREATED);
    }
    
    @PutMapping("/{ticketId}")
    public ResponseEntity<Ticket> updateTicket(
            @PathVariable String ticketId,
            @Valid @RequestBody TicketRequest ticketRequest) {
        
        Ticket ticket = new Ticket();
        ticket.setFlightNo(ticketRequest.getFlightNo());
        ticket.setPlaneSeatId(ticketRequest.getPlaneSeatId());
        ticket.setUserId(ticketRequest.getPassengerId());
        ticket.setHasInFlightEntertainment(ticketRequest.getHasInFlightEntertainment());
        ticket.setBaggageCapInPlane(ticketRequest.getBaggageCapInPlane());
        ticket.setBaggageCapUnderPlane(ticketRequest.getBaggageCapUnderPlane());
        ticket.setHasFoodService(ticketRequest.getHasFoodService());
                
        return ticketService.updateTicket(ticketId, ticket)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String ticketId) {
        return ticketService.deleteTicket(ticketId) 
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
} 