package com.andrew.oauth2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/user")
    public ResponseEntity<String> user(@AuthenticationPrincipal OAuth2User principal) {
        String name = principal.getAttribute("name");
        System.out.println(name);
        return ResponseEntity.status(HttpStatus.OK).body(name);
    }

    @GetMapping("/test")
    public ResponseEntity<String> user() {
        return ResponseEntity.status(HttpStatus.OK).body("testing");
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        System.out.println("logout");
        request.getSession().invalidate();
    }

}