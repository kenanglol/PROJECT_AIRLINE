package com.airline.planeservice.service;

import com.airline.planeservice.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(String ticketId);
    List<Ticket> getTicketsByFlightNo(String flightNo);
    Ticket createTicket(Ticket ticket);
    Optional<Ticket> updateTicket(String ticketId, Ticket ticket);
    boolean deleteTicket(String ticketId);
} 