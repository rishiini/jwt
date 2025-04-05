package com.example.jwt.Controller;

import com.example.jwt.Dto.AuthRequest;
import com.example.jwt.Model.User;
import com.example.jwt.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request.getUsername(), request.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request.getUsername(), request.getPassword()));
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("You have been successfully logged out");
    }
}

