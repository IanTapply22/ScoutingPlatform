# ScoutingPlatformAPI
An API used for ease of use when creating scouting data for FRC competitions. Commonly integrated in a vuejs or react app.

## How to run the API
1. Make sure you have [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) and [Maven](https://apache.maven.org) installed.

2. Clone and fork this respository in a safe directory.
You can do this by running...
```
$ git clone https://github.com/<your username>/ScoutingPlatformAPI
```

3. Navigate yourself into the folder.
```
cd ScoutingPlatformAPI
```

4. Install all of the maven dependencies.
```
mvn install
```

5. Run the Rest API!
```
mvn spring-boot:run
```

> Note, please be sure to configure the application.yml file before running the API as you will run into errors with storing the users and it clearing users on every deploy. It is not our responsibility if you do not follow this IMPORTANT step.

## Notes
This was all possible mainly because of Firebase for storing data and Spring Boot for the actual API.
