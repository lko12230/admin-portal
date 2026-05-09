package com.admin.controller;

import com.admin.security.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {

        try {

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            data.get("username"),
                            data.get("password")
                    )
            );

            String role = auth.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority) // ROLE_ADMIN
                    .findFirst()
                    .orElse("ROLE_USER");

            String token = jwtUtil.generateToken(auth.getName(), role);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "username", auth.getName(),
                    "role", role
            ));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid Credentials ❌");
        }
    }
}