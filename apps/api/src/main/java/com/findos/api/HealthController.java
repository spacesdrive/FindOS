package com.findos.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This handles web request for checking the health
@RestController
@RequestMapping("/api/health")
public class HealthController {

    // This method runs when we someone sends a GET request
    @GetMapping
    public String health() {
        return "UP";
    }
}