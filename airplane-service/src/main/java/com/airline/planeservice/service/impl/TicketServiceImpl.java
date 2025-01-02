package com.airline.planeservice.service.impl;

import com.airline.commons.entity.Ticket;
import com.airline.commons.entity.Flight;
import com.airline.commons.entity.Plane;
import com.airline.planeservice.repository.TicketRepository;
import com.airline.planeservice.service.TicketService;
import com.airline.planeservice.service.PlaneService;
import com.airline.planeservice.client.FlightFeignClient;
import com.airline.planeservice.dto.TicketRequest;
import com.airline.planeservice.dto.TicketResponse;
import com.airline.commons.exception.BusinessException;
import com.airline.commons.exception.InvalidRequestException;
import com.airline.commons.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    
    private final TicketRepository ticketRepository;
    private final PlaneService planeService;
    private final FlightFeignClient flightFeignClient;
    
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
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        Flight flight = flightFeignClient.getFlightByFlightNo(ticketRequest.getFlightNo());
        if (flight == null) {
            throw new ResourceNotFoundException("Uçuş bulunamadı: " + ticketRequest.getFlightNo());
        }

        boolean isReserved = ticketRepository.existsByFlightNoAndPlaneSeatId(
            ticketRequest.getFlightNo(), 
            ticketRequest.getPlaneSeatId()
        );
        
        if (isReserved) {
            throw new BusinessException("Bu koltuk zaten rezerve edilmiş: " + ticketRequest.getPlaneSeatId());
        }

        Plane plane = planeService.getPlaneById(flight.getPlaneId());
        if (ticketRequest.getPlaneSeatId() > plane.getTotalSeats()) {
            throw new InvalidRequestException("Geçersiz koltuk numarası: " + ticketRequest.getPlaneSeatId());
        }

        // Yeni bilet oluştur
        Ticket ticket = Ticket.builder()
                .ticketId(generateTicketId())
                .flightNo(ticketRequest.getFlightNo())
                .planeSeatId(ticketRequest.getPlaneSeatId())
                .passengerName(ticketRequest.getPassengerName())
                .price(ticketRequest.getPrice())
                .build();

        Ticket savedTicket = ticketRepository.save(ticket);
        return mapToTicketResponse(savedTicket);
    }
    
    @Override
    public Optional<Ticket> updateTicket(String ticketId, Ticket ticket) {
        if (!ticketRepository.existsById(ticketId)) {
            return Optional.empty();
        }
        ticket.setTicketId(ticketId);
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

    private String generateTicketId() {
        // Örnek: TKT-yyyyMMdd-XXXXX formatında unique ID oluştur
        return "TKT-" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + 
               "-" + String.format("%05d", (int) (Math.random() * 100000));
    }

    private TicketResponse mapToTicketResponse(Ticket ticket) {
        return TicketResponse.builder()
                .ticketId(ticket.getTicketId())
                .flightNo(ticket.getFlightNo())
                .planeSeatId(ticket.getPlaneSeatId())
                .passengerName(ticket.getPassengerName())
                .price(ticket.getPrice())
                .build();
    }
} 