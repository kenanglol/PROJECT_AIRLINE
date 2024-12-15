package com.airline.userinfoservice.repository;

import com.airline.userinfoservice.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    boolean existsByPassportNo(String passportNo);
} 