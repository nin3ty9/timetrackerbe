package com.timetrackerbe.timetrackerbe.services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import com.timetrackerbe.timetrackerbe.models.Activity;
import java.util.Optional;


public interface ActivityRepository extends MongoRepository<Activity, String> {

    Optional<Activity> findById(String id);

    @Update ("{'$set': {'activityName': ?1}}")
    public void findAndSetNameById(String id, String newActivityName);
}
