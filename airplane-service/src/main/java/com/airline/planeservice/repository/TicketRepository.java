package com.airline.planeservice.repository;

import com.airline.commons.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByFlightNo(String flightNo);
    boolean existsByFlightNoAndPlaneSeatId(String flightNo, Integer planeSeatId);
} 