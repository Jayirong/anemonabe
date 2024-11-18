package com.anemona.anemonabe.service;

import java.util.List;

import com.anemona.anemonabe.model.User;

public interface UserService {
    User registerUser(User user);
    User findByUsername(String username);
    User findUserById(Long id);
    List<User> findAllUsers();
    User updateUser(String currentUsername, User updatedUser);
    void deleteUserById(Long id);
    String authenticateAndGenerateToken(String username, String password);
}
