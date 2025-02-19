package com.capgemini.intermediate_problems.sort_csv_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Utility class to handle CSV file reading, searching, and sorting
public class CSVReader {
    public static List<Employee> readCSV(String filePath) {
        String current = "src/main/java/com/capgemini/intermediate_problems/sort_csv_record/" + filePath;

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


    public static List<Employee> getTopPaidEmployees(String filePath, int topN) {
        String current = "src/main/java/com/capgemini/intermediate_problems/sort_csv_record/" + filePath;

        List<Employee> employees = readCSV(current);
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        return employees.subList(0, Math.min(topN, employees.size()));
    }
}