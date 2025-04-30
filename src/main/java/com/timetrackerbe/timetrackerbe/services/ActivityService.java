package com.timetrackerbe.timetrackerbe.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.timetrackerbe.timetrackerbe.models.Activity;

@Service
public class ActivityService {
    
    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity getActivityById(String id) {
        Optional<Activity> activity = activityRepository.findById(id);

        if (activity.isPresent()) {
            return activity.get();
        } else {
            return null;
        }
    }
}
