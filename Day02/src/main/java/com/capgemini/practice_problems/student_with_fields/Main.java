package com.capgemini.practice_problems.student_with_fields;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //create a JSON array
        JSONArray studentArray = new JSONArray();

        //create a JSON object for 1st student
        JSONObject student1 = new JSONObject();
        student1.put("name","Om Tiwari");
        student1.put("age","22");
        student1.put("subjects",new JSONArray(Arrays.asList("Maths", "Chemistry", "Science")));

        //create a JSON object for 1st student
        JSONObject student2 = new JSONObject();
        student2.put("name","Harsh veer singh");
        student2.put("age","62");
        student2.put("subjects",new JSONArray(Arrays.asList("Maths", "Biology", "Hindi")));

        studentArray.put(student1);
        studentArray.put(student2);

        System.out.println(studentArray.toString(4));
    }
}
