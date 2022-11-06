package me.iantapply.scoutingPlatform.API;

import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import me.iantapply.scoutingPlatform.services.FirebaseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v2/public")
public class PublicAPI {

    /*
    // Config values
    private final ConfigurationUtils configurationUtils;

    public PublicAPI(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }


    //TODO: implement a dashboard for easy adding and removing of stats (most likely using react and firebase)
    //TODO: implement an optional authentication system (most likely using JWT or a simple password and key system)
    //TODO: add some more options, maybe some booleans for if requests can be made to endpoints

    @RequestMapping(method = RequestMethod.GET, value = "stats/{teamID}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamStats getStats(@PathVariable Integer teamID, @PathVariable Integer year) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for year " + year + "with team ID" + teamID);

        // Return stats from the specified year
        return FirebaseService.getTeamStatsInformation(teamID, year);
    }

    @RequestMapping(method = RequestMethod.GET, value = "team/{teamID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team getStats(@PathVariable Integer teamID) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for info on team with ID" + teamID);

        // Return stats from the specified year
        return FirebaseService.getTeamInformation(teamID);
    }

    @RequestMapping(method = RequestMethod.GET, value = "teams", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeamBuilder>> getAllTeams() {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for all teams");

        // Return every team in the "teams" collection
        return ResponseEntity.ok(FirebaseService.getAllTeams());
    }

    @RequestMapping(method = RequestMethod.GET, value = "teamStats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeamStatsBuilder>> getAllTeamStats() {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for all team stats");

        // Return every team in the "teams" collection
        return ResponseEntity.ok(FirebaseService.getAllTeamStats());
    }
    */
}
