package me.iantapply.scoutingPlatform.newAPI;

import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.objects.ScoutingData;
import me.iantapply.scoutingPlatform.services.NewFirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class PublicAPINew {

    /**
     * GET scouting data calls
     */

    @RequestMapping(method = RequestMethod.GET, value = "/scoutingData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScoutingDataBuilder> allScoutingData() throws ExecutionException, InterruptedException {

        //ConfigurationUtils.checkForDebug("GET", "scoutingData");
        return NewFirebaseService.getAllScoutingData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/scoutingData/{teamID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScoutingData allScoutingDataForTeam(@PathVariable Integer teamID) throws ExecutionException, InterruptedException {

        ConfigurationUtils.checkForDebug("GET", "scoutingData" + teamID);
        return NewFirebaseService.getScoutingDataForTeam(teamID);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/scoutingData/{teamID}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScoutingData allScoutingDataFromTeamAndYear(@PathVariable Integer teamID, @PathVariable String date) throws ExecutionException, InterruptedException {

        ConfigurationUtils.checkForDebug("GET", "scoutingData" + teamID + "/" + date);
        return NewFirebaseService.getScoutingDataFromTeamAndYear(teamID, date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/scoutingData/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ScoutingData allScoutingDataFromYear(@PathVariable String date) throws ExecutionException, InterruptedException {

        ConfigurationUtils.checkForDebug("GET", "scoutingData" + date);
        return NewFirebaseService.getAllScoutingDataFromYear(date);
    }
}
