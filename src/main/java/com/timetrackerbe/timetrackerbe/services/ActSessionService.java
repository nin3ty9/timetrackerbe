package com.timetrackerbe.timetrackerbe.services;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.timetrackerbe.timetrackerbe.models.ActSession;
import com.timetrackerbe.timetrackerbe.models.Activity;

@Service
public class ActSessionService {

    private ActSessionRepository actSessionRepository;
    private ActivityRepository activityRepository;

    public ActSessionService(ActSessionRepository actSessionRepository, ActivityRepository activityRepository) {
            this.actSessionRepository = actSessionRepository;
            this.activityRepository = activityRepository;
    }

    public List<ActSession> getActSessions() {
        return actSessionRepository.findAll();
    }

    public ActSession getActSessionById(String sessionId) {
        Optional<ActSession> actSession = actSessionRepository.findById(sessionId);

        if (actSession.isPresent()) {
            return actSession.get();
        } else {
            return null;
        }
    }

    public ActSession createActSession(ActSession actSession) {
        Activity activity = activityRepository.findById(actSession.getActivity().getId())
            .orElseThrow(() -> new RuntimeException("Activity not found"));

        actSession.setActivity(activity);

        Duration calculatedDuration = Duration.between(actSession.getActStart(), actSession.getActEnd());
        actSession.setDuration(calculatedDuration);
        
        return actSessionRepository.save(actSession);
    }

    public ActSession editActSessionById(String sessionId, ActSession actSession) {
        Activity activity = activityRepository.findById(actSession.getActivity().getId())
            .orElseThrow(() -> new RuntimeException("Activity not found"));

        actSession.setActivity(activity);

        Duration calculatedDuration = Duration.between(actSession.getActStart(), actSession.getActEnd());
        actSession.setDuration(calculatedDuration);

        return actSessionRepository.save(actSession);
    }
    
}
