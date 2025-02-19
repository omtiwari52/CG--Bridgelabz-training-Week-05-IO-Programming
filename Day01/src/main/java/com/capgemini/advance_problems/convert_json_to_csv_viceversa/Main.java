package com.capgemini.advance_problems.convert_json_to_csv_viceversa;

import static com.capgemini.advance_problems.convert_json_to_csv_viceversa.JSONCSVConverter.csvToJSON;
import static com.capgemini.advance_problems.convert_json_to_csv_viceversa.JSONCSVConverter.jsonToCSV;

public class Main {
    public static void main(String[] args) {
        try {
            // Convert JSON to CSV
            jsonToCSV("src/main/java/com/capgemini/advance_problems/convert_json_to_csv_viceversa/students.json", "src/main/java/com/capgemini/advance_problems/convert_json_to_csv_viceversa/students.csv");

            // Convert CSV to JSON
            csvToJSON("src/main/java/com/capgemini/advance_problems/convert_json_to_csv_viceversa/students.json", "src/main/java/com/capgemini/advance_problems/convert_json_to_csv_viceversa/students.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
