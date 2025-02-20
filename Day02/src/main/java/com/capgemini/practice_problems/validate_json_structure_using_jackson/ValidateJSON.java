package com.capgemini.practice_problems.validate_json_structure_using_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJSON {
    public static boolean isValidJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(new File(filePath), User.class);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}