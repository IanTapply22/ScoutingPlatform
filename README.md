# ScoutingPlatformAPI
An API used for ease of use when creating scouting data for FRC competitions. Commonly integrated in a vuejs or react app.

## API Calls

GET www.example.com/scoutingData <br>
Result: All scouting data from the collection set in application.yml file.

GET www.example.com/scoutingData?teamID= <br>
Result: All scouting data for the specified teamID.

GET www.example.com/scoutingData?teamID=&date= <br>
Result: All scouting data created for the specified team on a specific date.

GET www.example.com/scoutingData?date= <br>
Result: All scouting data created on the date specified (includes every team).

## Notes
This was all possible mainly because of Firebase for storing data and Spring Boot for the actual API.
