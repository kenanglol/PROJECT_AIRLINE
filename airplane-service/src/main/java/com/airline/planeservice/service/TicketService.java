package com.airline.planeservice.service;

import com.airline.commons.entity.Ticket;
import com.airline.planeservice.dto.TicketRequest;
import com.airline.planeservice.dto.TicketResponse;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(String ticketId);
    List<Ticket> getTicketsByFlightNo(String flightNo);
    TicketResponse createTicket(TicketRequest ticketRequest);
    Optional<Ticket> updateTicket(String ticketId, Ticket ticket);
    boolean deleteTicket(String ticketId);
} 