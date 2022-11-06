package me.iantapply.scoutingPlatform.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class FirebaseService {

    /**
     *
     * @param year the year to get the information from
     * @return information on the specific team from the specific year
     * @throws ExecutionException
     * @throws InterruptedException
     */
    /*
    public static TeamStats getTeamStatsInformation(Integer teamID, Integer year) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("stats").document(teamID + "-" + year);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        TeamStats teamStats = null;

        if (document.exists()) {
            teamStats = document.toObject(TeamStats.class);
            return teamStats;
        } else {
            return null;
        }
    }

    public static Team getTeamInformation(Integer teamID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("teams").document(String.valueOf(teamID));
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Team team = null;

        if (document.exists()) {
            team = document.toObject(Team.class);
            return team;
        } else {
            return null;
        }
    }

    public static List<TeamBuilder> getAllTeams() {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        try {
            return dbFirestore.collection("teams").get().get().getDocuments().parallelStream()
                    .map(team -> {
                        final var teamDocument = team.toObject(Team.class);
                        return TeamBuilder.builder().id(team.getId()).city(teamDocument.getCity()).district(teamDocument.getDistrict())
                                .rookieYear(teamDocument.getRookieYear()).school(teamDocument.getSchool()).teamID(teamDocument.getTeamID())
                                .teamName(teamDocument.getTeamName()).website(teamDocument.getWebsite())
                                .build();
                    }).collect(Collectors.toList());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Unable to retrieve all teams from database: teams");
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public static List<TeamStatsBuilder> getAllTeamStats() {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        try {
            return dbFirestore.collection("stats").get().get().getDocuments().parallelStream()
                    .map(teamStats -> {
                        final var teamDocument = teamStats.toObject(TeamStats.class);
                        return TeamStatsBuilder.builder().id(teamStats.getId()).district(teamDocument.getDistrict()).ranked(teamDocument.getRanked())
                                .teamID(teamDocument.getTeamID()).teamName(teamDocument.getTeamName()).totalPoints(teamDocument.getTotalPoints())
                                .year(teamDocument.getYear())
                                .build();
                    }).collect(Collectors.toList());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Unable to retrieve all teams from database: stats");
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public static String createTeamStatsByYear(TeamStats teamStats) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsAPIFuture = dbFirestore.collection("stats").document(teamStats.getTeamID() + "-" + teamStats.getYear()).set(teamStats);
        return collectionsAPIFuture.get().getUpdateTime().toString();
    }

    public static String createTeam(Team team) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsAPIFuture = dbFirestore.collection("teams").document(String.valueOf(team.getTeamID())).set(team);
        return collectionsAPIFuture.get().getUpdateTime().toString();
    }

    public static String deleteTeamStats(Integer teamID, Integer year) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("stats").document(teamID + "-" + year).delete();
        return "Stats with ID " + teamID + " and year " + year + " has been deleted!";
    }

    public static String deleteTeam(Integer teamID) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("teams").document(String.valueOf(teamID)).delete();
        return "Team with ID " + teamID + " has been deleted!";
    }

    public static String updateStats(TeamStats teamStats) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("stats").document(teamStats.getTeamID() + "-" + teamStats.getYear()).set(teamStats);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public static String updateTeam(Team team) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("teams").document(String.valueOf(team.getTeamID())).set(team);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    */

}
