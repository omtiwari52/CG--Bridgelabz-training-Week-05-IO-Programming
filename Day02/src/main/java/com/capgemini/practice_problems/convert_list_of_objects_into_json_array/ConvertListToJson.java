package com.capgemini.practice_problems.convert_list_of_objects_into_json_array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertListToJson {

    //method to convert list to Json
    public static String convertToJson(List<Student> students){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            System.out.println(jsonArray);
            return jsonArray;
        } catch (JsonProcessingException e) {
            System.out.println("Exception Caught: "+ e.getMessage());
        }
        return null;
    }
}
