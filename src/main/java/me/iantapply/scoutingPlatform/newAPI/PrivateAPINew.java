package me.iantapply.scoutingPlatform.newAPI;

import me.iantapply.scoutingPlatform.objects.ScoutingData;
import me.iantapply.scoutingPlatform.services.NewFirebaseService;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/scoutingData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createScoutingData(@RequestBody ScoutingData scoutingData) throws ExecutionException, InterruptedException {

        configurationUtils.checkForDebug("POST", "scoutingData");
        return ResponseEntity.ok(NewFirebaseService.saveScoutingData(scoutingData));
    }

    /**
     * PATCH scouting data call(s)
     */

    /**
     * DELETE scouting data call(s)
     */
}
