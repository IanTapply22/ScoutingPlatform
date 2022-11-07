package me.iantapply.scoutingPlatform.builders;

import lombok.Builder;
import lombok.Data;
import me.iantapply.scoutingPlatform.enums.MoveInAuto;
import me.iantapply.scoutingPlatform.enums.TournamentType;

@Data
@Builder
public class ScoutingDataBuilder {

    // Miscellaneous
    private String firebaseDocumentID;
    private String userID;
    private Integer teamID;
    private String date;
    private TournamentType tournamentType;
    private Integer matchNumber;
    private MoveInAuto moveInAuto;

    // Shooting
    private Integer autoHighMade;
    private Integer autoHighMissed;
    private Integer autoLowMade;
    private Integer autoLowMissed;
    private Integer teleopHighMade;
    private Integer teleopHighMissed;
    private Integer teleopLowMade;

    // Climbing
    private Integer climbLevel;
    private Integer climbTime;
}
