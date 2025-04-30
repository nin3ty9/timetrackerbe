package com.timetrackerbe.timetrackerbe.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timetrackerbe.timetrackerbe.models.Activity;
import com.timetrackerbe.timetrackerbe.services.ActivityService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ActivityController {
    
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

@GetMapping("/activities")
public List<Activity> getActivities() {
    return activityService.getActivities();
}

@GetMapping("/activity/{id}")
public Activity getActivityById(@RequestParam String id) {
    return activityService.getActivityById(id);
}

@PostMapping("/activity")
public Activity createActivity(@RequestBody Activity activity) {
    return activityService.createActivity(activity);
}


}
