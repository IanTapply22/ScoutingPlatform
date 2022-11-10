package me.iantapply.scoutingPlatform.newAPI;

import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.objects.ScoutingData;
import me.iantapply.scoutingPlatform.services.NewFirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class PublicAPINew {

    private final ConfigurationUtils configurationUtils;
    public PublicAPINew(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }

    /**
     * GET scouting data calls
     */

    // Get all data
    @GetMapping(path="/scoutingData")
    public List<ScoutingDataBuilder> allScoutingData() throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData");
        return NewFirebaseService.getAllScoutingData();
    }

    // Get all for team
    @GetMapping(path="/scoutingData", params = { "teamID" })
    public List<ScoutingDataBuilder> allScoutingDataForTeam(@RequestParam Integer teamID) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + teamID);
        return NewFirebaseService.getScoutingDataForTeam(teamID);
    }

    // Get all for team on date
    @GetMapping(path="/scoutingData", params = { "teamID", "date" })
    public ScoutingData allScoutingDataFromTeamAndYear(@RequestParam Integer teamID, @RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + teamID + "/" + date);
        return NewFirebaseService.getScoutingDataFromTeamAndYear(teamID, date);
    }

    // Get all for date
    @GetMapping(path="/scoutingData", params = { "date" })
    public ScoutingData allScoutingDataFromYear(@RequestParam String date) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("GET", "scoutingData" + date);
        return NewFirebaseService.getAllScoutingDataFromYear(date);
    }
}
