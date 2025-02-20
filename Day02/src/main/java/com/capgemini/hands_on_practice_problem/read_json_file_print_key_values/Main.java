package com.capgemini.hands_on_practice_problem.read_json_file_print_key_values;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonArray = objectMapper.readTree(new File("src/main/java/com/capgemini/hands_on_practice_problem/read_json_file_print_key_values/sample.json"));

            //check if json root node is an array
            if(jsonArray.isArray()){
                System.out.println("Printing all keys and values:");
                for(JsonNode jsonNode : jsonArray){
                    // Iterate through all key-value pairs
                    Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                    while (fields.hasNext()) {
                        Map.Entry<String, JsonNode> entry = fields.next();
                        System.out.println(entry.getKey() + ": " + entry.getValue().asText());
                    }
                    System.out.println("------------------------------");
                }
            }else {
                // Iterate through all key-value pairs
                Iterator<Map.Entry<String, JsonNode>> fields = jsonArray.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    System.out.println(entry.getKey() + ": " + entry.getValue().asText());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception Caught: "+e.getMessage());
        }
    }
}
