package com.timetrackerbe.timetrackerbe.services;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // Duration calculatedDuration = Duration.between(actSession.getActStart(), actSession.getActEnd());
        // actSession.setDuration(calculatedDuration);

        long calculatedDurationSeconds = Duration.between(actSession.getActStart(), actSession.getActEnd()).getSeconds();
        actSession.setDurationSeconds(calculatedDurationSeconds);

        
        return actSessionRepository.save(actSession);
    }

    public ActSession editActSessionById(String sessionId, ActSession actSession) {
        Activity activity = activityRepository.findById(actSession.getActivity().getId())
            .orElseThrow(() -> new RuntimeException("Activity not found"));

        actSession.setActivity(activity);

        long calculatedDurationSeconds = Duration.between(actSession.getActStart(), actSession.getActEnd()).getSeconds();
        actSession.setDurationSeconds(calculatedDurationSeconds);

        return actSessionRepository.save(actSession);
    }

    public Map<String, Long> getTotalStatsByActivity() {
        // Hämtar alla actSessions
        List<ActSession> actSessions = actSessionRepository.findAll();
        
        // Grupperar durations
        Map<String, Long> totalStats = actSessions.stream()
            .collect(Collectors.groupingBy(
                actSession -> actSession.getActivity().getActivityName(),
                Collectors.summingLong(ActSession::getDurationSeconds)
            ));
        
        return totalStats;
    }
}
    

