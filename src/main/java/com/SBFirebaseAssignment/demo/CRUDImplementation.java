package com.SBFirebaseAssignment.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDImplementation {

    public String createStudent(Student student){
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = db.collection("assignment1").document(student.getId()).set(student);
        return "Added successfully!";
    }

    public Student getStudent(String id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("assignment1").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot doc = future.get();

        Student student;
        if(doc.exists()){
            student = doc.toObject(Student.class);
            return student;
        }
        return null;
    }

    public String updateStudent(Student student, String id){
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = db.collection("assignment1").document(student.getId()).set(student);
        return "Updated successfully!";
    }

    public String deleteStudent(String id){
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = db.collection("assignment1").document(id).delete();
        return "Successfully deleted student with ID: "+ id;
    }
}
