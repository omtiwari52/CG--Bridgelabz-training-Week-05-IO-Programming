package com.capgemini.basic_problems.read_and_count_row_in_csv_file;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Employee.merged.csv"; // Provide the correct path
        List<Student> students = CSVReader.readCSV(filePath);
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Number of row in the file is " + CSVReader.countRecords(filePath));
    }
}
