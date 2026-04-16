package com.ecommerce.cart.controller;

import com.ecommerce.cart.dto.request.LoginRequest;
import com.ecommerce.cart.dto.request.RegisterRequest;
import com.ecommerce.cart.dto.response.ApiResponse;
import com.ecommerce.cart.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginRequest request) {
    	log.info("Login request recived");
    	
        return ResponseEntity.ok(authService.login(request));
    }
    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody RegisterRequest request) {
    	log.info("Registration request recived");
    	
        return ResponseEntity.ok(authService.register(request));
    }
}