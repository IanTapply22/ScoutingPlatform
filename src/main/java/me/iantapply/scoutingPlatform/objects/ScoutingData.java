package me.iantapply.scoutingPlatform.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.iantapply.scoutingPlatform.enums.MoveInAuto;
import me.iantapply.scoutingPlatform.enums.TournamentType;

public class ScoutingData {

    // Get and set the values provided
    /**
     * Will use UUID most likely for userID
     */
    @Getter @Setter String userID;
    @Getter @Setter Integer teamID;
    @Getter @Setter String date;
    @Getter @Setter TournamentType tournamentType;
    @Getter @Setter Integer matchNumber;
    @Getter @Setter MoveInAuto moveInAuto;

    @Getter @Setter Integer autoHighMade;
    @Getter @Setter Integer autoHighMissed;
    @Getter @Setter Integer autoLowMade;
    @Getter @Setter Integer autoLowMissed;
    @Getter @Setter Integer teleopHighMade;
    @Getter @Setter Integer teleopHighMissed;
    @Getter @Setter Integer teleopLowMade;
    @Getter @Setter Integer climbLevel;
    @Getter @Setter Integer climbTime;

    public ScoutingData() {
        super();
    }
}
