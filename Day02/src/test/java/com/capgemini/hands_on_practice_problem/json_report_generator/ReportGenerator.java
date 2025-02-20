package com.capgemini.hands_on_practice_problem.json_report_generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportGenerator {
    @Test
    void checkWrite(){
        boolean result = JsonReportGenerator.writeReport();
        assertTrue(result);
    }
}
