package com.capgemini.advance_problems.convert_csv_data_into_java_objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static void main(String[] args) {
        String current = "Students.csv"; // Path to your CSV file
        List<Student> students = new ArrayList<>();

        String filePath = "src/main/java/com/capgemini/advance_problems/convert_csv_data_into_java_objects/" + current;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header if it exists
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming CSV is comma-separated

                // Create a Student object from the CSV row
                String name = values[0].trim();
                int age = Integer.parseInt(values[1].trim());
                String grade = values[2].trim();

                // Add Student object to the list
                students.add(new Student(name, age, grade));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
