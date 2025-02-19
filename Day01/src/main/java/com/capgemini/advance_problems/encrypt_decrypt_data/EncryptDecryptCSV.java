package com.capgemini.advance_problems.encrypt_decrypt_data;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;
import java.io.*;

import java.security.Key;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "1234567890123456";

    // Encrypt data using AES
    public static String encrypt(String data) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData); // Encode in Base64 to store it as a string
    }

    // Decrypt data using AES
    public static String decrypt(String encryptedData) throws Exception {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    // Write encrypted employee data to CSV
    public static void writeEncryptedCSV(String filePath) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        // Writing header
        writer.write("Employee ID,Name,Department,Salary,Email");
        writer.newLine();

        // Sample employee data -> Changed in the file while decrypt during running time
        String[][] employees = {
                {"101", "John Doe", "HR", "55000.0", "john.doe@example.com"},
                {"102", "Jane Smith", "Finance", "65000.0", "jane.smith@example.com"},
                {"103", "Sam Brown", "IT", "75000.0", "sam.brown@example.com"}
        };

        // Writing data with encrypted Salary and Email
        for (String[] employee : employees) {
            String employeeId = employee[0];
            String name = employee[1];
            String department = employee[2];
            String encryptedSalary = encrypt(employee[3]);
            String encryptedEmail = encrypt(employee[4]);

            writer.write(employeeId + "," + name + "," + department + "," + encryptedSalary + "," + encryptedEmail);
            writer.newLine();
        }

        writer.close();
    }

    // Read and decrypt employee data from CSV
    public static void readDecryptedCSV(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Read header
        String header = reader.readLine();
        System.out.println(header);

        // Read and decrypt data
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            String employeeId = fields[0];
            String name = fields[1];
            String department = fields[2];
            String decryptedSalary = decrypt(fields[3]);
            String decryptedEmail = decrypt(fields[4]);

            System.out.println(employeeId + "," + name + "," + department + "," + decryptedSalary + "," + decryptedEmail);
        }

        reader.close();
    }


}

