package com.capgemini.hands_on_practice_problem.convert_csv_data_into_json;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class CsvToJsonConverterTest {

    @Test
    void testConvertCsvToJson() {
        String csvFilePath = "src/main/java/com/capgemini/hands_on_practice_problem/convert_csv_data_into_json/sample.csv"; // Ensure correct path

        try {
            // Ensure the file exists before proceeding
            assertTrue(Files.exists(Paths.get(csvFilePath)), "CSV file not found!");

            // Convert CSV to JSON
            String jsonOutput = CsvToJsonConverter.convertCsvToJson(csvFilePath);
            System.out.println("Actual JSON Output:\n" + jsonOutput);

            // Validate JSON output is not null or empty
            assertNotNull(jsonOutput);
            assertFalse(jsonOutput.isEmpty());

            assertTrue(jsonOutput.contains("name"));
            assertTrue(jsonOutput.contains("omtiwari800@gmail.com"));
            assertTrue(jsonOutput.contains("22"));

            System.out.println("✅ Test Passed");

        } catch (Exception e) {
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}