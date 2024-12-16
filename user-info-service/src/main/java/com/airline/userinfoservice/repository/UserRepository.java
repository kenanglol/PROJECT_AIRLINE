package com.airline.userinfoservice.repository;

import com.airline.userinfoservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByMail(String mail);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
} 