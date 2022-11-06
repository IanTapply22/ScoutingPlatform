package me.iantapply.scoutingPlatform.API;

import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import me.iantapply.scoutingPlatform.services.FirebaseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v2/administrator")
public class AdministratorAPI {

    /*
    private final ConfigurationUtils configurationUtils;

    public AdministratorAPI(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }


    @PostMapping(value = "createTeamStats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTeamStats(@RequestBody TeamStats teamStats) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for creation of team stats for " + teamStats.getTeamName() + " for year " + teamStats.getYear() + "!");

        // Create team stats for the year
        return ResponseEntity.ok(FirebaseService.createTeamStatsByYear(teamStats));
    }

    @PostMapping(value = "createTeam", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTeam(@RequestBody Team team) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for creation of team " + team.getTeamName() + "with ID " + team.getTeamID());

        // Create team
        return ResponseEntity.ok(FirebaseService.createTeam(team));
    }

    @DeleteMapping(value = "deleteStats/{teamID}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTeamStats(@RequestBody Integer teamID, Integer year) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for deletion of team stats with ID" + teamID + " with year " + year + "!");

        // Delete team
        return ResponseEntity.ok(FirebaseService.deleteTeam(teamID));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTeam/{teamID}")
    public ResponseEntity<String> deleteTeam(@PathVariable Integer teamID) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for deletion of team with ID" + teamID + "!");

        // Delete team
        return ResponseEntity.ok(FirebaseService.deleteTeam(teamID));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStats")
    public ResponseEntity<String> updateStats(@RequestBody TeamStats teamStats) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for updating of team with ID" + teamStats.getTeamID() + " for year " + teamStats.getYear() + "!");

        // Update stats
        return ResponseEntity.ok(FirebaseService.updateStats(teamStats));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTeam")
    public ResponseEntity<String> updateTeam(@RequestBody Team team) throws ExecutionException, InterruptedException {
        // Debug console output
        if (configurationUtils.getDebug())
            System.out.println("Received call for updating of team with ID" + team.getTeamID() + "!");

        // Update team
        return ResponseEntity.ok(FirebaseService.updateTeam(team));
    }
     */
}
