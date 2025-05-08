package com.timetrackerbe.timetrackerbe.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Controller enbart för health-checks:
@RestController
public class HealthController {

    @GetMapping("/")
    public String healthCheck() {
        return "Backend is up!";
    }
}
