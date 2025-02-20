package com.capgemini.hands_on_practice_problem.validate_an_email;

public class Main {
    public static void main(String[] args) {

        String schemaPath = "src/main/java/com/capgemini/hands_on_practice_problem/validate_an_email/schema.json";
        String dataPath = "src/main/java/com/capgemini/hands_on_practice_problem/validate_an_email/sample_data.json";

        ValidateJson.isValid(schemaPath, dataPath);
    }
}
