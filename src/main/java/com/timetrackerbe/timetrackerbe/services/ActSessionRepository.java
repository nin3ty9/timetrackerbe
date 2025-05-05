package com.timetrackerbe.timetrackerbe.services;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import com.timetrackerbe.timetrackerbe.models.ActSession;
import com.timetrackerbe.timetrackerbe.models.Activity;

public interface ActSessionRepository extends MongoRepository<ActSession, String> {

    List<ActSession> findByActivity(Activity activity);

    Optional<ActSession> findById(String sessionId);

    // @Query("{'sessionId': ?0} { '$set': { 'activity': ?1 } }")
    // public void findAndSetActivityById(String sessionId, Activity newActivity);
}
