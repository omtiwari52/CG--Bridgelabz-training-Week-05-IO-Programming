package com.capgemini.intermediate_problems.filter_records_from_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {

    //method to filter records from a csv file
    public static void filterRecord(String fileName){

        String filePath = "src/main/java/com/capgemini/intermediate_problems/filter_records_from_csv/" + fileName;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String line;
            boolean headerSkipped = false;

            System.out.println("Students with marks > 80: ");
            System.out.println("ID\tName\tMarks");
            System.out.println("----------------------");

            while((line = br.readLine()) != null){

                //check if line is not blank
                if(!line.trim().isEmpty()){
                    if(!headerSkipped){
                        headerSkipped = true;
                        continue;
                    }

                    //split CSV line into an array
                    String[] data = line.split(",");

                    //extract student details
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int marks = Integer.parseInt(data[2].trim());

                    //filter student with marks > 80
                    if(marks > 80){
                        System.out.println(id + "\t" + name + "\t" + marks);
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
