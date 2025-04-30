package com.timetrackerbe.timetrackerbe.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.timetrackerbe.timetrackerbe.models.ActSession;

@Service
public class ActSessionService {

    private ActSessionRepository actSessionRepository;

    public ActSessionService(ActSessionRepository actSessionRepository) {
        this.actSessionRepository = actSessionRepository;
    }

    public List<ActSession> getActSessions() {
        return actSessionRepository.findAll();
    }

    public List<ActSession> findByActivityId(String activityId) {
        return actSessionRepository.findByActivityId(activityId);
    }

    public ActSession findActSessionById(String sessionId) {
        Optional<ActSession> actSession = actSessionRepository.findById(sessionId);

        if (actSession.isPresent()) {
            return actSession.get();
        } else {
            return null;
        }
    }

    public ActSession createActSession(ActSession actSession) {
        return actSessionRepository.save(actSession);
    }
    
}
