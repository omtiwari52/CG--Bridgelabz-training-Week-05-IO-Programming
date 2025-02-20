package com.capgemini.practice_problems.validate_json_structure_using_jackson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateJsonTest {
    @Test
    void checkValidType(){
        String filePath = "src/main/java/com/capgemini/practice_problems/validate_json_structure_using_jackson/sample.json";
        assertTrue(ValidateJSON.isValidJson(filePath));
        System.out.println("✅ Test1 Passed");
    }
}