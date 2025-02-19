package com.capgemini.advance_problems.merge_csv_file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {
        String file1 = "src/main/java/com/capgemini/advance_problems/merge_csv_file/file1.csv";
        String file2 = "src/main/java/com/capgemini/advance_problems/merge_csv_file/file2.csv";
        String outputFile = "src/main/java/com/capgemini/advance_problems/merge_csv_file/merged.csv"; // Output merged file

        Map<String, String[]> studentsData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            br1.readLine(); // Skip header
            while ((line = br1.readLine()) != null) {
                String[] fields = line.split(",");
                String id = fields[0];
                String name = fields[1];
                String age = fields[2];
                studentsData.put(id, new String[] {name, age}); // Store Name and Age by ID
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Write the header for the merged file
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
                String line;
                br2.readLine(); // Skip header
                while ((line = br2.readLine()) != null) {
                    String[] fields = line.split(",");
                    String id = fields[0];
                    String marks = fields[1];
                    String grade = fields[2];

                    if (studentsData.containsKey(id)) {
                        String[] studentInfo = studentsData.get(id);
                        String name = studentInfo[0];
                        String age = studentInfo[1];

                        writer.write(id + "," + name + "," + age + "," + marks + "," + grade);
                        writer.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Files merged successfully into " + outputFile);
    }
}
