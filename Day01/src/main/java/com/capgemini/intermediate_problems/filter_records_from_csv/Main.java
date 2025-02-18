package com.capgemini.intermediate_problems.filter_records_from_csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        //using try and catch to handle exception if occurs
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            //get user input for file name
            System.out.print("Enter file name: ");
            String fileName = br.readLine();

            FilterRecords.filterRecord(fileName);

        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
