package com.capgemini.advance_problems.generate_csv_report_from_database;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String url = "url link"; // Database URL
        String user = "your_username"; // Database username
        String password = "your_password"; // Database password
        String filePath = "employees_report.merged.csv"; // Path for the CSV file

        // SQL query to fetch employee data
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Write the header to the CSV file
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Process each record and write to the CSV file
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                // Write employee data to the CSV file
                writer.write(employeeId + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
