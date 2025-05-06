package com.timetrackerbe.timetrackerbe.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.timetrackerbe.timetrackerbe.models.ActSession;
import com.timetrackerbe.timetrackerbe.services.ActSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class ActSessionController {
    
    private final ActSessionService actSessionService;

    public ActSessionController(ActSessionService actSessionService) {
        this.actSessionService = actSessionService;
    }

    @GetMapping("/api/actSessions")
    public List<ActSession> getActSessions() {
        return actSessionService.getActSessions();
    }
    
    @GetMapping("/api/actSession/{sessionId}")
    public ActSession getActSessionById(@PathVariable String sessionId) {
        return actSessionService.getActSessionById(sessionId);
    }

    @PostMapping("/api/actSession")
    public ActSession createactSession(@RequestBody ActSession actSession) {
        return actSessionService.createActSession(actSession);
    }

    @PatchMapping("/api/actSession/{sessionId}")
    public ActSession editaActSessionById(@PathVariable String sessionId, @RequestBody ActSession actSession) {
        return actSessionService.editActSessionById(sessionId, actSession);
    }

    @GetMapping("/api/actSessions/totalStats")
    public Map<String, Long> getTotalStatsByActivity() {
        return actSessionService.getTotalStatsByActivity();
    }

    @GetMapping("/api/actSessions/totalStatsByWeek")
    public Map<String, Map<String, Long>> getTotalStatsByWeek() {
    return actSessionService.getTotalStatsByWeek();
}

}