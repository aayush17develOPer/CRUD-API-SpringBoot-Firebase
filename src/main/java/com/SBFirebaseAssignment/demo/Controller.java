package com.SBFirebaseAssignment.demo;

import com.google.cloud.firestore.Firestore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class Controller {
    public CRUDImplementation crudImplementation;

    public Controller(CRUDImplementation crudImplementation){
        this.crudImplementation = crudImplementation;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        return crudImplementation.createStudent(student);
    }

    @GetMapping("/read")
    public Student getStudent(@RequestParam String id) throws ExecutionException, InterruptedException {
        return crudImplementation.getStudent(id);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student, @RequestParam String id){
        return crudImplementation.updateStudent(student,id);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam String id){
        return crudImplementation.deleteStudent(id);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testFunc(){
        return ResponseEntity.ok("Application is working!");
    }
}
