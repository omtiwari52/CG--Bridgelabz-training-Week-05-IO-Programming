package com.capgemini.hands_on_practice_problem.read_json_file_print_key_values;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    void testReadJsonArray() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(new File("src/main/java/com/capgemini/hands_on_practice_problem/read_json_file_print_key_values/sample.json"));

        // Check if JSON is an array....these two test cases will only run if we will give json array as input
        assertTrue(jsonArray.isArray());
        System.out.println("✅ Test1 Passed");
        assertEquals(2, jsonArray.size()); // Check if 2 objects exist
        System.out.println("✅ Test2 Passed");

        // Verify student details
        assertEquals("Om Tiwari", jsonArray.get(0).get("name").asText());
        assertEquals("harshveer@gmail.com", jsonArray.get(1).get("email").asText());
        assertEquals(22, jsonArray.get(0).get("age").asInt());
        assertEquals("Aami-valley", jsonArray.get(1).get("city").asText());
        System.out.println("✅ Test3 Passed");
    }
}
