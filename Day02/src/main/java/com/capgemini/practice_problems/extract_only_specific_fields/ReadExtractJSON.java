package com.capgemini.practice_problems.extract_only_specific_fields;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadExtractJSON {

    //method to read a Json file and extract only email and name
    public static List<User> extractSpecificDetails(String fileName) throws IOException {

        String filePath = "src/main/java/com/capgemini/practice_problems/extract_only_specific_fields/"+fileName;

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> users = objectMapper.readValue(new File(filePath), new TypeReference<List<User>>(){});

        for(User user : users){
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("-------------------");
        }
        return users;
    }
}
