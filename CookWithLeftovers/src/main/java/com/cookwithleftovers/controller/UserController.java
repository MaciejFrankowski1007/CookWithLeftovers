package com.cookwithleftovers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookwithleftovers.domain.User;
import com.cookwithleftovers.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("User already exists.");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userService.validateUser(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        }
        return ResponseEntity.badRequest().body("Invalid username or password.");
    }
}
