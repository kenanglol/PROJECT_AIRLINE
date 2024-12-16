package com.airline.userinfoservice.service.impl;

import com.airline.userinfoservice.entity.User;
import com.airline.userinfoservice.repository.UserRepository;
import com.airline.userinfoservice.service.UserService;
import com.airline.userinfoservice.config.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityConfig.CustomPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByMail(user.getMail())) {
            throw new RuntimeException("Email already exists");
        }
        
        String salt = passwordEncoder.generateSalt();
        user.setSalt(salt);
        user.setPassword(passwordEncoder.encode(user.getPassword(), salt));
        
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        
        if (!existingUser.getUsername().equals(user.getUsername()) && 
            userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        
        if (!existingUser.getMail().equals(user.getMail()) && 
            userRepository.existsByMail(user.getMail())) {
            throw new RuntimeException("Email already exists");
        }

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String salt = passwordEncoder.generateSalt();
            user.setSalt(salt);
            user.setPassword(passwordEncoder.encode(user.getPassword(), salt));
        } else {
            user.setPassword(existingUser.getPassword());
            user.setSalt(existingUser.getSalt());
        }

        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        
        if (!passwordEncoder.matches(password, user.getPassword(), user.getSalt())) {
            throw new RuntimeException("Geçersiz şifre");
        }
        
        return user;
    }

    @Override
    public User loginWithUsername(String username, String password) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        
        if (!passwordEncoder.matches(password, user.getPassword(), user.getSalt())) {
            throw new RuntimeException("Geçersiz şifre");
        }
        
        return user;
    }
} 