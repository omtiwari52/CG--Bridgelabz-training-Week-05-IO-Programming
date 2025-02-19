package com.capgemini.advance_problems.validate_csv_data_before_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {

    //method to valid CSV
    public static void isValid(String fileName){

        String filePath = "src/main/java/com/capgemini/advance_problems/validate_csv_data_before_processing/"+ fileName;

        // Define regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;


                // Split CSV row into columns
                String[] data = line.split(",");

                // Ensure correct column count
                if (data.length < 4) {
                    System.out.println("Invalid row at line " + lineNum + ": Missing values");
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();
                String department = data[3].trim();

                // Validate email
                Matcher emailMatcher = emailPattern.matcher(email);
                boolean isEmailValid = emailMatcher.matches();

                // Validate phone number
                Matcher phoneMatcher = phonePattern.matcher(phone);
                boolean isPhoneValid = phoneMatcher.matches();

                // Print errors for invalid data
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Error at line " + lineNum + ": " + line);
                    if (!isEmailValid) System.out.println("   ❌ Invalid Email: " + email);
                    if (!isPhoneValid) System.out.println("   ❌ Invalid Phone Number: " + phone);
                } else {
                    System.out.println("✅ Valid Data: " + line);
                }
            }
        }catch (IOException e){
            System.out.println("Exception caught "+ e.getMessage());
        }
    }
}
