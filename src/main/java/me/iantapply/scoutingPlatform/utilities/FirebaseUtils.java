package me.iantapply.scoutingPlatform.utilities;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import me.iantapply.scoutingPlatform.builders.ScoutingDataBuilder;
import me.iantapply.scoutingPlatform.dto.ScoutingDataDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class FirebaseUtils {

    /**
     * WILL MAKE A SEPARATE API FOR THIS AS ALL OF THESE METHODS ARE MESSY
     */

    private static ConfigurationUtils configurationUtils = null;
    public FirebaseUtils(ConfigurationUtils configurationUtils) {
        FirebaseUtils.configurationUtils = configurationUtils;
    }

    public static List<ScoutingDataBuilder> findDocumentsContaining(String field, Integer value) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        CollectionReference scoutingData = dbFirestore.collection(configurationUtils.getFirestoreDataCollection());
        Query query = scoutingData.whereEqualTo(field, value);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<ScoutingDataBuilder> result;
        result = querySnapshot.get().getDocuments().parallelStream()
                .map(scoutingData2 -> {
                    final var scoutingDataDocument = scoutingData2.toObject(ScoutingDataDTO.class);
                    return ScoutingDataBuilder.builder().firebaseDocumentID(scoutingData2.getId()).userID(scoutingDataDocument.getUserID())
                            .teamID(scoutingDataDocument.getTeamID()).date(scoutingDataDocument.getDate()).tournamentType(scoutingDataDocument.getTournamentType())
                            .matchNumber(scoutingDataDocument.getMatchNumber()).moveInAuto(scoutingDataDocument.getMoveInAuto())
                            .autoHighMade(scoutingDataDocument.getAutoHighMade()).autoHighMissed(scoutingDataDocument.getAutoHighMissed()).autoLowMade(scoutingDataDocument.getAutoLowMade())
                            .autoLowMissed(scoutingDataDocument.getAutoLowMissed()).teleopHighMade(scoutingDataDocument.getTeleopHighMade()).teleopHighMissed(scoutingDataDocument.getTeleopHighMissed())
                            .teleopLowMade(scoutingDataDocument.getTeleopLowMade()).climbLevel(scoutingDataDocument.getClimbLevel()).climbTime(scoutingDataDocument.getClimbTime()).build();
                }).collect(Collectors.toList());

        return result;
    }

    public static List<ScoutingDataBuilder> findDocumentsContaining(String field1, Integer value1, String field2, String value2) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        CollectionReference scoutingData = dbFirestore.collection(configurationUtils.getFirestoreDataCollection());
        Query query = scoutingData.whereEqualTo(field1, value1).whereEqualTo(field2, value2);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<ScoutingDataBuilder> result;
        result = querySnapshot.get().getDocuments().parallelStream()
                .map(scoutingData2 -> {
                    final var scoutingDataDocument = scoutingData2.toObject(ScoutingDataDTO.class);
                    return ScoutingDataBuilder.builder().firebaseDocumentID(scoutingData2.getId()).userID(scoutingDataDocument.getUserID())
                            .teamID(scoutingDataDocument.getTeamID()).date(scoutingDataDocument.getDate()).tournamentType(scoutingDataDocument.getTournamentType())
                            .matchNumber(scoutingDataDocument.getMatchNumber()).moveInAuto(scoutingDataDocument.getMoveInAuto())
                            .autoHighMade(scoutingDataDocument.getAutoHighMade()).autoHighMissed(scoutingDataDocument.getAutoHighMissed()).autoLowMade(scoutingDataDocument.getAutoLowMade())
                            .autoLowMissed(scoutingDataDocument.getAutoLowMissed()).teleopHighMade(scoutingDataDocument.getTeleopHighMade()).teleopHighMissed(scoutingDataDocument.getTeleopHighMissed())
                            .teleopLowMade(scoutingDataDocument.getTeleopLowMade()).climbLevel(scoutingDataDocument.getClimbLevel()).climbTime(scoutingDataDocument.getClimbTime()).build();
                }).collect(Collectors.toList());

        return result;
    }

    public static List<ScoutingDataBuilder> findDocumentsContaining(String field, String value) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        CollectionReference scoutingData = dbFirestore.collection(configurationUtils.getFirestoreDataCollection());
        Query query = scoutingData.whereEqualTo(field, value);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<ScoutingDataBuilder> result;
        result = querySnapshot.get().getDocuments().parallelStream()
                .map(scoutingData2 -> {
                    final var scoutingDataDocument = scoutingData2.toObject(ScoutingDataDTO.class);
                    return ScoutingDataBuilder.builder().firebaseDocumentID(scoutingData2.getId()).userID(scoutingDataDocument.getUserID())
                            .teamID(scoutingDataDocument.getTeamID()).date(scoutingDataDocument.getDate()).tournamentType(scoutingDataDocument.getTournamentType())
                            .matchNumber(scoutingDataDocument.getMatchNumber()).moveInAuto(scoutingDataDocument.getMoveInAuto())
                            .autoHighMade(scoutingDataDocument.getAutoHighMade()).autoHighMissed(scoutingDataDocument.getAutoHighMissed()).autoLowMade(scoutingDataDocument.getAutoLowMade())
                            .autoLowMissed(scoutingDataDocument.getAutoLowMissed()).teleopHighMade(scoutingDataDocument.getTeleopHighMade()).teleopHighMissed(scoutingDataDocument.getTeleopHighMissed())
                            .teleopLowMade(scoutingDataDocument.getTeleopLowMade()).climbLevel(scoutingDataDocument.getClimbLevel()).climbTime(scoutingDataDocument.getClimbTime()).build();
                }).collect(Collectors.toList());

        return result;
    }
}
