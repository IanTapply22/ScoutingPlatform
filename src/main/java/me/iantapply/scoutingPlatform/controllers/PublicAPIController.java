package me.iantapply.scoutingPlatform.controllers;

import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.dto.ScoutingDataDTO;
import me.iantapply.scoutingPlatform.services.FirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class PublicAPIController {

    private final ConfigurationUtils configurationUtils;
    public PublicAPIController(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }

    /**
     * GET scouting data calls
     */

    // Get all data
    @GetMapping(path="/scoutingData")
    public List<ScoutingDataBuilder> allScoutingData() throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData");
        return FirebaseService.getAllScoutingData();
    }

    // Get all for team
    @GetMapping(path="/scoutingData", params = { "teamID" })
    public List<ScoutingDataBuilder> allScoutingDataForTeam(@RequestParam Integer teamID) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + teamID);
        return FirebaseService.getScoutingDataForTeam(teamID);
    }

    // Get all for team on date
    @GetMapping(path="/scoutingData", params = { "teamID", "date" })
    public ScoutingDataDTO allScoutingDataFromTeamAndYear(@RequestParam Integer teamID, @RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + teamID + "/" + date);
        return FirebaseService.getScoutingDataFromTeamAndYear(teamID, date);
    }

    // Get all for date
    @GetMapping(path="/scoutingData", params = { "date" })
    public ScoutingDataDTO allScoutingDataFromYear(@RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + date);
        return FirebaseService.getAllScoutingDataFromYear(date);
    }
}
