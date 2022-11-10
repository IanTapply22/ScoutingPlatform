package me.iantapply.scoutingPlatform.newAPI;

import me.iantapply.scoutingPlatform.objects.ScoutingData;
import me.iantapply.scoutingPlatform.services.NewFirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PrivateAPINew {

    private final ConfigurationUtils configurationUtils;
    public PrivateAPINew(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }


    /**
     * POST scouting data call(s)
     */

    // Create data
    @PostMapping(path="/scoutingData")
    public ResponseEntity<String> createScoutingData(@RequestBody ScoutingData scoutingData) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("POST", "/scoutingData");
        return ResponseEntity.ok(NewFirebaseService.saveScoutingData(scoutingData));
    }


    /**
     * PATCH scouting data call(s)
     */

    // Update data
    @PatchMapping(path="/scoutingData")
    public ResponseEntity<String> updateScoutingData(@RequestBody ScoutingData scoutingData) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("PATCH", "/scoutingData");
        return ResponseEntity.ok(NewFirebaseService.saveScoutingData(scoutingData));
    }


    /**
     * DELETE scouting data call(s)
     */

    // Delete data for team on a specific date
    @DeleteMapping(path="/scoutingData", params = { "teamID", "date" })
    public ResponseEntity<String> deleteScoutingDataTeamAndDate(@RequestParam Integer teamID, @RequestParam String date) {

        configurationUtils.checkForDebug("DELETE", "/scoutingData?teamID=" + teamID + "&date=" + date);
        return ResponseEntity.ok(NewFirebaseService.deleteScoutingData(teamID, date));
    }

    // Delete data for a specific match for a team on a specific day
    @DeleteMapping(path="/scoutingData", params = { "teamID", "date", "match" })
    public ResponseEntity<String> deleteScoutingDataTeamDateAndMatch(@RequestParam Integer teamID, @RequestParam String date, @RequestParam Integer match) {

        configurationUtils.checkForDebug("DELETE", "/scoutingData?teamID=" + teamID + "&date=" + date + "&match=" + match);
        return ResponseEntity.ok(NewFirebaseService.deleteScoutingData(teamID, date, match));
    }

    // Delete all data for every team (will add more auth for this)
    @DeleteMapping(path="/scoutingData")
    public ResponseEntity<String> deleteAllScoutingData() {

        configurationUtils.checkForDebug("DELETE", "/scoutingData");
        return ResponseEntity.ok(NewFirebaseService.deleteAllScoutingData());
    }

    // Delete all data that was made on a specific day
    @DeleteMapping(path="/scoutingData", params = { "date" })
    public ResponseEntity<String> deleteAllScoutingDataForDate(@RequestParam String date) {

        configurationUtils.checkForDebug("DELETE", "/scoutingData?date=" + date);
        return ResponseEntity.ok(NewFirebaseService.deleteAllScoutingData(date));
    }

    // Delete all scouting data for a team
    @DeleteMapping(path="/scoutingData", params = { "teamID" })
    public ResponseEntity<String> deleteAllScoutingDataForTeam(@RequestParam Integer teamID) {

        configurationUtils.checkForDebug("DELETE", "/scoutingData?teamID=" + teamID);
        return ResponseEntity.ok(NewFirebaseService.deleteAllScoutingData(teamID));
    }
}
