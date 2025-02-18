package com.capgemini.basic_problems.write_data_to_a_csv_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            //get user input for file name
            System.out.print("Enter file name: ");
            String fileName = br.readLine();

            String[] employeeData = {"115, Om Tiwari, AIML, 28000",
                    "69 , Harshveer Thakur, AIML, 2000",
                    "143, Sahil Jain, AIML, 42000",
                    "039, Arnav Pandey, AIML, 43000",
                    "103, Neha Gour, AIML, 29000"
            };

            WriteDataToCSV.write(employeeData,fileName);
        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
