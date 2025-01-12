package com.cookwithleftovers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookwithleftovers.domain.User;
import com.cookwithleftovers.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean validateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}
