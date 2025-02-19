package com.capgemini.intermediate_problems.search_in_csv_file;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Employee.csv"; // Provide the correct path
        List<Employee> employees = CSVReader.readCSV(filePath);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        String searchName = "Harsh veer";
        Employee employee = CSVReader.searchEmployee(filePath, searchName);
        if (employee != null) {
            System.out.println("Employee Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
