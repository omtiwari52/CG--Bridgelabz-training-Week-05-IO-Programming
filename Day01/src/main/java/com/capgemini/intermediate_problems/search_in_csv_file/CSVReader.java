package com.capgemini.intermediate_problems.search_in_csv_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Utility class to handle CSV file reading
public class CSVReader {
    public static List<Employee> readCSV(String filePath) {
        String current = "src/main/java/com/capgemini/intermediate_problems/search_in_csv_file/" + filePath;
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(current))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    String department = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim());
                    employees.add(new Employee(name, department, salary));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return employees;
    }

    public static Employee searchEmployee(String filePath, String searchName) {

        String current = "src/main/java/com/capgemini/intermediate_problems/search_in_csv_file/" + filePath;

        try (BufferedReader br = new BufferedReader(new FileReader(current))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3 && data[0].trim().equalsIgnoreCase(searchName)) {
                    return new Employee(data[0].trim(), data[1].trim(), Double.parseDouble(data[2].trim()));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return null;
    }
}