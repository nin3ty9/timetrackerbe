package com.timetrackerbe.timetrackerbe.models;
import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actSessions")
public class ActSession {
    
    @Id
    private String sessionId;

    private String activityId;

    private LocalDateTime actStart;
    private LocalDateTime actEnd;
    private Duration duration;

    public ActSession(String sessionId, String activityId, LocalDateTime actStart,
    LocalDateTime actEnd, Duration duration) {
    
        this.sessionId = sessionId;
        this.activityId = activityId;
        this.actStart = actStart;
        this.actEnd = actEnd;
        this.duration = duration;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public LocalDateTime getActStart() {
        return actStart;
    }

    public void setActStart(LocalDateTime actStart) {
        this.actStart = actStart;
    }

    public LocalDateTime getActEnd() {
        return actEnd;
    }

    public void setActEnd(LocalDateTime actEnd) {
        this.actEnd = actEnd;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    
}
