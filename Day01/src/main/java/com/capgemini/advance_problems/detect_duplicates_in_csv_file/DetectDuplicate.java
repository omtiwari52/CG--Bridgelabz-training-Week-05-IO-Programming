package com.capgemini.advance_problems.detect_duplicates_in_csv_file;

import java.io.*;
import java.util.*;

public class DetectDuplicate {

    //method to find duplicate in csv file
    public static void findDuplicates(String fileName){
        String filePath = "src/main/java/com/capgemini/advance_problems/detect_duplicates_in_csv_file/" + fileName;  // CSV file name

        Set<String> idSet = new HashSet<>(); // Stores unique IDs
        List<String> duplicateRecords = new ArrayList<>(); // Stores duplicate records

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;

                // Skip header row
                if (lineNum == 1) continue;

                // Split CSV row into columns
                String[] data = line.split(",");

                // Ensure correct column count
                if (data.length < 4) {
                    System.out.println("Invalid row at line " + lineNum + ": Missing values");
                    continue;
                }

                String id = data[0].trim();  // Assuming ID is the first column

                // Check for duplicate ID
                if (!idSet.add(id)) {
                    duplicateRecords.add(line);
                }
            }

            // Print duplicates if found
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate IDs found!");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(" Wrong " + record);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
