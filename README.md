# TimeTracker API

This application serves as the backend of my TimeTracker app (timetrackerfe).
The idea of the application is to track the amount of time the user spends on different activities
and get total and weekly statistics on time use.

## Setup

To run this app locally, you need to clone both this repo and the frontend repo, as well as setting
up your own MongoDB database to handle saved activities and activity sessions.
The frontend is made with React + Typescript + Vite and the backend is a Spring Boot api.
**Start by setting up the backend and database, then configure a few things here in the backend:**

1. The CorsConfig is currently set up for production. To run locally, this line of the CorsConfig:
**".allowedOrigins("https://lobster-app-gnq4y.ondigitalocean.app")"**
needs to be changed to:
**".allowedOrigins("*")"**
(or your chosen origin) in order to allow the locally run frontend to have access. 

2. /src/main/resources/application.properties is set up for hidden environment variables for the database.
These lines:
**"spring.data.mongodb.uri=${MONGO_URI}
server.port=8080"
need to be swapped for:
"spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017"** (or whichever port your MongoDB database i configured to)

You can run the backend in your IDE with the play button while
**src/main/java/com/timetrackerbe/timetrackerbe/TimetrackerbeApplication.java** is open in your editor.
Once it's up and running with your database, you can either try it out with Postman or set up the and run
the frontend (timetrackerfe) to use the app in your browser.

-------------------------------------------------------------------------------------------------------
