package com.SBFirebaseAssignment.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Student {
    private String id;
    private String name;
    private Map<String,Float> subjMarks;
}
