package com.capgemini.hands_on_practice_problem.convert_json_to_xml_format;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class Converter {

    // Method to convert JSON file to XML
    public static String convertJsonFileToXml(String jsonFilePath) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(new File(jsonFilePath));

            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to XML: " + e.getMessage());
        }
    }
}
