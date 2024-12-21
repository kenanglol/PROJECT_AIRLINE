package com.airline.planeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airline.planeservice.entity.Ticket;
import com.airline.planeservice.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    
    private final TicketService ticketService;
    
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
    
    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable String ticketId) {
        return ticketService.getTicketById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/plane/{flightNo}")
    public List<Ticket> getTicketsByFlightNo(@PathVariable String flightNo) {
        return ticketService.getTicketsByFlightNo(flightNo);
    }
    
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }
    
    @PutMapping("/{ticketId}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable String ticketId, @RequestBody Ticket ticket) {
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