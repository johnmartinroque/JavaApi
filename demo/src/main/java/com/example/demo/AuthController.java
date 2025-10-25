package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Temporary in-memory "database"
    private Map<String, String> users = new HashMap<>();

    // ✅ Register new user
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (users.containsKey(user.getUsername())) {
            return "❌ Username already exists!";
        }
        users.put(user.getUsername(), user.getPassword());
        return "✅ Registration successful!";
    }

    // ✅ Login user
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        String storedPassword = users.get(user.getUsername());
        if (storedPassword != null && storedPassword.equals(user.getPassword())) {
            return "✅ Login successful!";
        }
        return "❌ Invalid username or password!";
    }
}
