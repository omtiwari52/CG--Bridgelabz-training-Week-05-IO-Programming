package com.capgemini.hands_on_practice_problem.validate_an_email;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJson {

    //method to validate if the Json is valid or not
    public static boolean isValid(String schemaPath, String dataPath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Load JSON Data
            JsonNode jsonData = objectMapper.readTree(new File(dataPath));

            // Validate JSON
            if (schema.validate(jsonData).isSuccess()) {
                System.out.println("JSON is valid!");
                return true;
            } else {
                System.out.println("Invalid JSON!");
                return false;
            }

        } catch (IOException | ProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
