package com.timetrackerbe.timetrackerbe.controllers;
import java.util.List;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.timetrackerbe.timetrackerbe.models.Activity;
import com.timetrackerbe.timetrackerbe.services.ActivityService;


@RestController
//@CrossOrigin(origins = "*")
public class ActivityController {
    
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/api/activities")
    public List<Activity> getActivities() {
        return activityService.getActivities();
    }

    @GetMapping("/api/activity/{id}")
    public Activity getActivityById(@PathVariable String id) {
        return activityService.getActivityById(id);
    }

    @PostMapping("/api/activity")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @PatchMapping("/api/activity/{id}")
    public Activity editActivityById(@PathVariable String id, @RequestBody Activity activity) {
        return activityService.editActivityById(id, activity);
    }


}
