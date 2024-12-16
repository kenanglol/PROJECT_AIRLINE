package com.airline.userinfoservice.service;

import com.airline.userinfoservice.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User login(String email, String password);
    User loginWithUsername(String username, String password);
} 