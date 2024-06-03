package com.SBFirebaseAssignment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class SpringBootFirebaseAssignmentApplication {

	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = SpringBootFirebaseAssignmentApplication.class.getClassLoader();
		InputStream serviceAccount = classLoader.getResourceAsStream("serviceAccountKey.json");

		assert serviceAccount != null;
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);
		SpringApplication.run(SpringBootFirebaseAssignmentApplication.class, args);
	}

}
