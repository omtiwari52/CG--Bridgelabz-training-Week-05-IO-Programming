package com.capgemini.advance_problems.encrypt_decrypt_data;

import static com.capgemini.advance_problems.encrypt_decrypt_data.EncryptDecryptCSV.readDecryptedCSV;
import static com.capgemini.advance_problems.encrypt_decrypt_data.EncryptDecryptCSV.writeEncryptedCSV;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/capgemini/advance_problems/encrypt_decrypt_data/dummy.merged.csv";

        try {
            // Write encrypted data to CSV
            writeEncryptedCSV(filePath);

            // Read and decrypt data from CSV
            System.out.println("Decrypted employee data:");
            readDecryptedCSV(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
