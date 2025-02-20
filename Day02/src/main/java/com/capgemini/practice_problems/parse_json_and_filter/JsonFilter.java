package com.capgemini.practice_problems.parse_json_and_filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFilter {

    //method to filter Json data
    public static List<Student> filter(String fileName){

        String filepath = "src/main/java/com/capgemini/practice_problems/parse_json_and_filter/" + fileName;

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Student> studentList = mapper.readValue(new File(filepath), new TypeReference<>() {});

            List<Student> filteredStudent = new ArrayList<>();
            for (Student student : studentList){

                //check if the age is greater is than 25
                if(student.getAge() > 25){
                    filteredStudent.add(student);
                }
            }

            System.out.println("Student with age > 25 :");
            for (Student student : filteredStudent){
                System.out.println(student);
            }

            return filteredStudent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
