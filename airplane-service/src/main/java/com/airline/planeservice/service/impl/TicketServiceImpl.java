package com.airline.planeservice.service.impl;

import com.airline.planeservice.entity.Ticket;
import com.airline.planeservice.repository.TicketRepository;
import com.airline.planeservice.service.TicketService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    
    private final TicketRepository ticketRepository;
    
    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    @Override
    public Optional<Ticket> getTicketById(String ticketId) {
        return ticketRepository.findById(ticketId);
    }
    
    @Override
    public List<Ticket> getTicketsByFlightNo(String flightNo){
        return ticketRepository.findByFlightNo(flightNo);
    }
    
    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    
    @Override
    public Optional<Ticket> updateTicket(String ticketId, Ticket ticket) {
        if (!ticketRepository.existsById(ticketId)) {
            return Optional.empty();
        }
        ticket.setPlaneSeatId(ticketId);
        return Optional.of(ticketRepository.save(ticket));
    }
    
    @Override
    public boolean deleteTicket(String ticketId) {
        if (!ticketRepository.existsById(ticketId)) {
            return false;
        }
        ticketRepository.deleteById(ticketId);
        return true;
    }
} 