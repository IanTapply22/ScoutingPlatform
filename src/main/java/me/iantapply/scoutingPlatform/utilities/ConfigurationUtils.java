package me.iantapply.scoutingPlatform.utilities;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
public class ConfigurationUtils {

    public static void checkForDebug(String callType, String endpoint) {
        if (ConfigurationUtils.getDebug()) {
            System.out.println("Call type: " + callType + " for endpoint: /" + endpoint + "/ has been successfully made!");
        }
    }

    // Debug option
    @Value("${stats-debug}")
    @Getter public static Boolean debug;

    // Service account key location
    @Value("${firebase-credentials-location}")
    @Getter private String firebaseCredentials;

    // Database type
    @Value("${firebase-storage-type}")
    @Getter private String storageType;

    // Realtime database url
    @Value("${firebase-realtime-url}")
    @Getter private String realtimeDatabaseURL;


    /**
     * Database options
     */
    @Value("${firestore-data-collection}")
    @Getter private String firestoreDataCollection;


    /**
     * Basic authentication config values
     */
    // Admin basic authentication details
    // Admin ID
    @Value("${client.admin.id}")
    @Getter private String id;

    // Admin Secret
    @Value("${client.admin.secret}")
    @Getter private String secret;


    /**
     * Authentication config values
     */
    // Private API authentication type
    @Value("${private-authentication-type}")
    @Getter private String privateAuth;

    // Admin API authentication type
    @Value("${admin-authentication-type}")
    @Getter private String adminAuth;
}
