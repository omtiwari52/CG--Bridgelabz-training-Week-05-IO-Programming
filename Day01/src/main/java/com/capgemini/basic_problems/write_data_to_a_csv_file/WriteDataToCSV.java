package com.capgemini.basic_problems.write_data_to_a_csv_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSV {

    //method to write data into csv file
    public static void write(String[] employeeData, String fileName){

        String filePath = "src/main/java/com/capgemini/basic_problems/write_data_to_a_csv_file/" + fileName;

        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))){

            //write in file
            br.write("ID, Name, Department, Salary");
            br.newLine();

            //write employee records
            for(String employee : employeeData){
                br.write(employee);
                br.newLine();
            }

            System.out.println("Details written in CSV file successfully");
        } catch (IOException e) {
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
