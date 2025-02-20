package com.capgemini.hands_on_practice_problem.convert_json_to_xml_format;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class JsonFileToXmlConverterTest {
    @Test
    void testConvertJsonFileToXml() {
        String jsonFilePath = "src/main/java/com/capgemini/hands_on_practice_problem/convert_json_to_xml_format/sample_data.json";

        try {
            // Convert JSON to XML
            String actualXml = Converter.convertJsonFileToXml(jsonFilePath);

            // Verify that XML is not null or empty
            assertNotNull(actualXml);
            assertFalse(actualXml.isEmpty());

            // Print XML for debugging (optional)
            System.out.println("Generated XML:\n" + actualXml);

            // Verify that the XML contains expected elements
            assertTrue(actualXml.contains("<students>"));
            assertTrue(actualXml.contains("<name>Om Tiwari</name>"));
            assertTrue(actualXml.contains("<age>22</age>"));
            assertTrue(actualXml.contains("<name>Harsh Veer</name>"));
            assertTrue(actualXml.contains("<email>harshveer@gmail.com</email>"));
            System.out.println("✅ Test Passed");
        } catch (Exception e) {
            fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
