package com.capgemini.practice_problems.validate_json_structure_using_jackson;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/capgemini/practice_problems/validate_json_structure_using_jackson/sample.json";
        if (ValidateJSON.isValidJson(filePath)) {
            System.out.println("Valid JSON structure!");
        } else {
            System.out.println("Invalid JSON structure!");
        }
    }
}
