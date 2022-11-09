package me.iantapply.scoutingPlatform.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.objects.ScoutingData;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class NewFirebaseService {

    private static ConfigurationUtils configurationUtils = null;
    public NewFirebaseService(ConfigurationUtils configurationUtils) {
        NewFirebaseService.configurationUtils = configurationUtils;
    }

    private static DatabaseReference mDatabase;

    /**
     * GET scouting data methods (public)
     */

    public static List<ScoutingDataBuilder> getAllScoutingData() throws ExecutionException, InterruptedException {
        List<ScoutingDataBuilder> result = null;
        switch (configurationUtils.getStorageType()) {
            case ("firestore"):
                Firestore dbFirestore = FirestoreClient.getFirestore();
                try {
                    result = dbFirestore.collection(configurationUtils.getFirestoreDataCollection()).get().get().getDocuments().parallelStream()
                            .map(scoutingData -> {
                                final var scoutingDataDocument = scoutingData.toObject(ScoutingData.class);
                                return ScoutingDataBuilder.builder().firebaseDocumentID(scoutingData.getId()).userID(scoutingDataDocument.getUserID())
                                        .teamID(scoutingDataDocument.getTeamID()).date(scoutingDataDocument.getDate()).tournamentType(scoutingDataDocument.getTournamentType())
                                        .matchNumber(scoutingDataDocument.getMatchNumber()).moveInAuto(scoutingDataDocument.getMoveInAuto())
                                        .autoHighMade(scoutingDataDocument.getAutoHighMade()).autoHighMissed(scoutingDataDocument.getAutoHighMissed()).autoLowMade(scoutingDataDocument.getAutoLowMade())
                                        .autoLowMissed(scoutingDataDocument.getAutoLowMissed()).teleopHighMade(scoutingDataDocument.getTeleopHighMade()).teleopHighMissed(scoutingDataDocument.getTeleopHighMissed())
                                        .teleopLowMade(scoutingDataDocument.getTeleopLowMade()).climbLevel(scoutingDataDocument.getClimbLevel()).climbTime(scoutingDataDocument.getClimbTime()).build();
                            }).collect(Collectors.toList());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Unable to retrieve all teams from collection: " + configurationUtils.getFirestoreDataCollection());
                    throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
                }
                break;

            case ("realtime"):
                break;
        }

        return result;
    }

    public static List<ScoutingDataBuilder> getScoutingDataForTeam(Integer teamID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        CollectionReference scoutingData = dbFirestore.collection(configurationUtils.getFirestoreDataCollection());
        Query query = scoutingData.whereEqualTo("teamID", teamID);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<ScoutingDataBuilder> result;
        result = querySnapshot.get().getDocuments().parallelStream()
                .map(scoutingData2 -> {
                    final var scoutingDataDocument = scoutingData2.toObject(ScoutingData.class);
                    return ScoutingDataBuilder.builder().firebaseDocumentID(scoutingData2.getId()).userID(scoutingDataDocument.getUserID())
                            .teamID(scoutingDataDocument.getTeamID()).date(scoutingDataDocument.getDate()).tournamentType(scoutingDataDocument.getTournamentType())
                            .matchNumber(scoutingDataDocument.getMatchNumber()).moveInAuto(scoutingDataDocument.getMoveInAuto())
                            .autoHighMade(scoutingDataDocument.getAutoHighMade()).autoHighMissed(scoutingDataDocument.getAutoHighMissed()).autoLowMade(scoutingDataDocument.getAutoLowMade())
                            .autoLowMissed(scoutingDataDocument.getAutoLowMissed()).teleopHighMade(scoutingDataDocument.getTeleopHighMade()).teleopHighMissed(scoutingDataDocument.getTeleopHighMissed())
                            .teleopLowMade(scoutingDataDocument.getTeleopLowMade()).climbLevel(scoutingDataDocument.getClimbLevel()).climbTime(scoutingDataDocument.getClimbTime()).build();
                }).collect(Collectors.toList());

        return result;
    }

    public static ScoutingData getScoutingDataFromTeamAndYear(Integer teamID, String date) throws ExecutionException, InterruptedException {
        return null;
    }

    public static ScoutingData getAllScoutingDataFromYear(String date) throws ExecutionException, InterruptedException {
        return null;
    }


    /**
     * POST, PATCH, DELETE, and PUT (create, update, delete, and replace)
     */

    public static String saveScoutingData(ScoutingData scoutingData) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(configurationUtils.getFirestoreDataCollection()).document(scoutingData.getTeamID() + "-" + scoutingData.getDate() + "-" + scoutingData.getMatchNumber()).set(scoutingData);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String deleteScoutingData(Integer teamID, String date) {
        return null;
    }

    public static String deleteScoutingData(Integer teamID, String date, Integer match) {
        return null;
    }


    /**
     * DELETE all scouting data methods
     */

    public static String deleteAllScoutingData() {
        return null;
    }

    public static String deleteAllScoutingData(String date) {
        return null;
    }

    public static String deleteAllScoutingData(Integer teamID) {
        return null;
    }
}
