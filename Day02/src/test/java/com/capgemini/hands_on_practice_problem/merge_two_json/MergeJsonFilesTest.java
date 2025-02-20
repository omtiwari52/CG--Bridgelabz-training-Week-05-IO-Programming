package com.capgemini.hands_on_practice_problem.merge_two_json;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeJsonFilesTest {

    @Test
    void testMergeJsonFiles() {
        String file1 = "src/main/java/com/capgemini/hands_on_practice_problem/merge_two_json/file1.json";
        String file2 = "src/main/java/com/capgemini/hands_on_practice_problem/merge_two_json/file2.json";

        JsonNode mergedJson = MergeJsonFiles.mergeJsonFiles(file1, file2);

        assertNotNull(mergedJson, "Merged JSON should not be null");
        assertEquals("Om Tiwari", mergedJson.get("name").asText());
        assertEquals("omtiwari800@gmail.com", mergedJson.get("email").asText());
        assertEquals(25, mergedJson.get("age").asInt());
        assertEquals("Bhopal", mergedJson.get("city").asText());
        assertEquals("India", mergedJson.get("country").asText());

        System.out.println("✅ Test Passed");
    }
}
