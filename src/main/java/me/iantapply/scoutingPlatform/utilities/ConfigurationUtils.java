package me.iantapply.scoutingPlatform.utilities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yml")
@org.springframework.context.annotation.Configuration
public class ConfigurationUtils {

    /**
     * Lombok getters for config options
     */

    // Debug option
    @Value("${stats-debug}")
    @Getter private Boolean debug;

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
    @Value("${firebase-data-collection}")
    @Getter @Setter
    private String firestoreDataCollection;


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

    /**
     * Temporary fix for options (will fix in future ASAP)
     */

    public void checkForDebug(String callType, String endpoint) {
        if (this.debug) {
            System.out.println("Call type: " + callType + " for endpoint: /" + endpoint + "/ has been successfully made!");
        }
    }
}
