package com.capgemini.intermediate_problems.sort_csv_record;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Employee.csv";
        CSVReader.readCSV(filePath);
        System.out.println("\nTop 5 Highest Paid Employees:");
        List<Employee> topEmployees = CSVReader.getTopPaidEmployees(filePath,5);
        for (Employee emp : topEmployees) {
            System.out.println(emp);
        }

    }
}
