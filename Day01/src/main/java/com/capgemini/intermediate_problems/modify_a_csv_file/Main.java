package com.capgemini.intermediate_problems.modify_a_csv_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //using try and catch to handle exception if occurs
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            //get user input for file name
            System.out.print("Enter source file name: ");
            String sourceFileName = br.readLine();

            //storing updated result in a list of string
            List<String[]> newDetails = UpdateCSVFile.readFile(sourceFileName);
            System.out.print("Details added but not added to new file \nPlease enter new file name to add details: ");

            //invoking write method to write updated details in new file and giving list of string array and destination file name
            String destinationFileName = br.readLine();
            UpdateCSVFile.writeFile(newDetails ,destinationFileName);

        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
