package com.capgemini.basic_problems.read_csv_file_and_print_data;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Employee.merged.csv"; // Provide the correct path
        List<Student> students = CSVReader.readCSV(filePath);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
