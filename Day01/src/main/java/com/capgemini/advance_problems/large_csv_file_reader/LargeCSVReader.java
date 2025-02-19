package com.capgemini.advance_problems.large_csv_file_reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    private static final int BATCH_SIZE = 100; // Number of records to process at a time

    public static void main(String[] args) {
        String filePath = "src/main/java/com/capgemini/advance_problems/large_csv_file_reader/Students.merged.csv"; // Path to the large CSV file
        int processedCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                // Skip the header line
                if (lineCount == 0) {
                    lineCount++;
                    continue;
                }


                String[] values = line.split(",");
                String name = values[0].trim();
                int age = Integer.parseInt(values[1].trim());
                String grade = values[2].trim();

                System.out.println("Processing: " + name + ", " + age + ", " + grade);

                // Count lines processed
                lineCount++;

                if (lineCount % BATCH_SIZE == 0) {
                    processedCount += BATCH_SIZE;
                    System.out.println("Processed " + processedCount + " records so far...");
                }
            }

            // If there are any remaining records less than 100 in the last batch
            if (lineCount % BATCH_SIZE != 0) {
                processedCount += lineCount % BATCH_SIZE;
                System.out.println("Processed " + processedCount + " records in total.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
