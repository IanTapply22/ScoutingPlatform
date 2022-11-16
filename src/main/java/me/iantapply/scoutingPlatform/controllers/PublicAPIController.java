package me.iantapply.scoutingPlatform.controllers;

import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.dto.ScoutingDataDTO;
import me.iantapply.scoutingPlatform.services.FirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/scoutingPlatform")
public class PublicAPIController {

    private final ConfigurationUtils configurationUtils;
    public PublicAPIController(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }

    /**
     * GET scouting data calls
     */

    // Get all data
    @GetMapping()
    public List<ScoutingDataBuilder> allScoutingData() throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingPlatform");
        return FirebaseService.getAllScoutingData();
    }

    // Get all for team
    @GetMapping(params = { "teamID" })
    public List<ScoutingDataBuilder> allScoutingDataForTeam(@RequestParam Integer teamID) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingPlatform" + teamID);
        return FirebaseService.getScoutingDataForTeam(teamID);
    }

    // Get all for team on date
    @GetMapping(params = { "teamID", "date" })
    public ScoutingDataDTO allScoutingDataFromTeamAndYear(@RequestParam Integer teamID, @RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingPlatform" + teamID + "/" + date);
        return FirebaseService.getScoutingDataFromTeamAndYear(teamID, date);
    }

    // Get all for date
    @GetMapping(params = { "date" })
    public ScoutingDataDTO allScoutingDataFromYear(@RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingPlatform" + date);
        return FirebaseService.getAllScoutingDataFromYear(date);
    }
}
