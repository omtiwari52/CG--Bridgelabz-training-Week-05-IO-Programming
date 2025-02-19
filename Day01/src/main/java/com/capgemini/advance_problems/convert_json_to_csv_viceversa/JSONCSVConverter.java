package com.capgemini.advance_problems.convert_json_to_csv_viceversa;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONCSVConverter {

    // Method to convert JSON to CSV
    public static void jsonToCSV(String jsonFile, String csvFile) throws Exception {
        // Read JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFile), List.class);

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header (keys from the first object in the list)
            List<String> headers = new ArrayList<>(students.get(0).keySet());
            writer.writeNext(headers.toArray(new String[0]));

            // Write student data
            for (Map<String, Object> student : students) {
                List<String> studentData = new ArrayList<>();
                for (String key : headers) {
                    studentData.add(student.get(key).toString());
                }
                writer.writeNext(studentData.toArray(new String[0]));
            }
        }
        System.out.println("JSON to CSV conversion is done.");
    }

    // Method to convert CSV to JSON
    public static void csvToJSON(String csvFile, String jsonFile) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Read the header
            String[] header = reader.readNext();
            String[] line;
            List<Map<String, String>> students = new ArrayList<>();

            // Read each line and convert to JSON
            while ((line = reader.readNext()) != null) {
                Map<String, String> student = new java.util.HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    student.put(header[i], line[i]);
                }
                students.add(student);
            }

            // Write to JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonFile), students);
        }
        System.out.println("CSV to JSON conversion is done.");
    }


}
