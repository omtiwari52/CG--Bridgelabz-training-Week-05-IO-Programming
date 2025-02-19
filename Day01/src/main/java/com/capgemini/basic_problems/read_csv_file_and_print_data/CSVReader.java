package com.capgemini.basic_problems.read_csv_file_and_print_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Utility class to handle CSV file reading
public class CSVReader {
    public static List<Student> readCSV(String filePath) {
        String fileLocation = "src/main/java/com/capgemini/basic_problems/read_csv_file_and_print_data/"+filePath;
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());
                    students.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return students;
    }
}