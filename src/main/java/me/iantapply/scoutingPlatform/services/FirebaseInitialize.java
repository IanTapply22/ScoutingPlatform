package me.iantapply.scoutingPlatform.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialize {

    // Configuration utils
    private static ConfigurationUtils configurationUtils = null;

    public FirebaseInitialize(ConfigurationUtils configurationUtils) {
        FirebaseInitialize.configurationUtils = configurationUtils;
    }

    @PostConstruct
    public static void initialize() throws IOException {
        switch (configurationUtils.getStorageType()) {
            case ("firestore"):

                // Firestore database initialization
                try {
                    FileInputStream serviceAccount = new FileInputStream(configurationUtils.getFirebaseCredentials());

                    FirebaseOptions options = FirebaseOptions.builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .build();

                    FirebaseApp app = null;
                    if (FirebaseApp.getApps().isEmpty()) {
                        app = FirebaseApp.initializeApp(options);
                    } else {
                        app = FirebaseApp.getApps().get(0);
                    }
                    System.out.println("Successfully initialized Firebase with storage type firestore!");
                } catch (IllegalArgumentException | IOException error) {
                    System.out.println("An error has occurred while enabling Firebase! This is most likely because you haven't set the contents of the firebaseCredentials.json file.");
                }
                break;
            case ("realtime"):

                // Realtime database initialization
                try {
                    FileInputStream serviceAccount = new FileInputStream(configurationUtils.getFirebaseCredentials());

                    FirebaseOptions options = FirebaseOptions.builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .setDatabaseUrl(configurationUtils.getRealtimeDatabaseURL())
                            .build();
                    FirebaseApp.initializeApp(options);

                    System.out.println("Successfully initialized Firebase with storage type realtime!");
                } catch (IllegalArgumentException | IOException error) {
                    System.out.println("An error has occurred while enabling firebase! This is most likely because you haven't set the contents of the firebaseCredentials.json file.");
                }
                break;
        }
    }
}
