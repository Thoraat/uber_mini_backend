package com.mini.ubet_backend.Controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthCheck {

    @GetMapping("/health")
    public String healthCheck(){
        return "running fine";
    }
}
