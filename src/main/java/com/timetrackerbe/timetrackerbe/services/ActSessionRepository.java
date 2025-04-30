package com.timetrackerbe.timetrackerbe.services;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.timetrackerbe.timetrackerbe.models.ActSession;

public interface ActSessionRepository extends MongoRepository<ActSession, String> {

    List<ActSession> findByActivityId(String activityId);

    Optional<ActSession> findById(String sessionId);
}
