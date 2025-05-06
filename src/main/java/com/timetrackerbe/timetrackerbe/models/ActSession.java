package com.timetrackerbe.timetrackerbe.models;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "actSessions")
public class ActSession {
    
    @Id
    private String sessionId;

    @DocumentReference
    private Activity activity;

    private LocalDateTime actStart;
    private LocalDateTime actEnd;
    private long durationSeconds;

    public ActSession(String sessionId, Activity activity, LocalDateTime actStart,
    LocalDateTime actEnd, long durationSeconds) {
    
        this.sessionId = sessionId;
        this.activity = activity;
        this.actStart = actStart;
        this.actEnd = actEnd;
        this.durationSeconds = durationSeconds;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    
}
