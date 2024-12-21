package com.airline.planeservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.planeservice.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByFlightNo(String flightNo);
} 