package com.timetrackerbe.timetrackerbe.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
public class Activity {
    
    @Id
    private String id;

    private String activityName;

    public Activity(String id, String activityName) {
        this.id = id;
        this.activityName = activityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActName() {
        return activityName;
    }

    public void setActName(String activityName) {
        this.activityName = activityName;
    }

    
}
