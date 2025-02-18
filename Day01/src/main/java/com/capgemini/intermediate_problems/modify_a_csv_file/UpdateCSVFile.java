package com.capgemini.intermediate_problems.modify_a_csv_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSVFile {

    //method to read CSV FILE
    public static  List<String[]> readFile(String sourceFileName){

        String sourceFilePath = "src/main/java/com/capgemini/intermediate_problems/modify_a_csv_file/"+ sourceFileName;
        List<String[]> updatedFileData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))){
            String line;

            boolean headerProcessed = false;

            while((line = br.readLine()) != null){

                if(!line.trim().isEmpty()){

                    String[] data = line.split(",");
                    if(!headerProcessed){
                        updatedFileData.add(data);
                        headerProcessed = true;
                        continue;
                    }

                    // extract employee data
                    String id = data[0].trim();
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary = Double.parseDouble(data[3].trim());


                    if(department.equalsIgnoreCase("AIML")){
                        salary *= 2;
                    }

                    updatedFileData.add(new String[]{id, name, department, String.valueOf(salary)});
                }
            }
        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
        return updatedFileData;
    }

    //method to write in different file
    public static void writeFile(List<String[]> employeesData, String destinationFileName){
        String destinationFilePath = "src/main/java/com/capgemini/intermediate_problems/modify_a_csv_file/"+ destinationFileName;

        //using buffered writer to write in a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))){
            for(String[] details : employeesData){
                writer.write(String.join(",",details));
                writer.newLine();
            }

            System.out.println("New file updated! Please check your file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
