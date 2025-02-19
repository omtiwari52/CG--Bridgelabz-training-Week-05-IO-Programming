package com.capgemini.advance_problems.detect_duplicates_in_csv_file;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        //using try and catch to handle exception if occurs
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            //get user input for file name
            System.out.print("Enter source file name: ");
            String sourceFileName = br.readLine();

            DetectDuplicate.findDuplicates(sourceFileName);

        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
