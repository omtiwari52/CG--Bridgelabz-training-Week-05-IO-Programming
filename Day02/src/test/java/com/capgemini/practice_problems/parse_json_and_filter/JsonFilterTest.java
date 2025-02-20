package com.capgemini.practice_problems.parse_json_and_filter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonFilterTest {

    @Test
    void filterTest1(){

        List<Student> filteredStudents = JsonFilter.filter("students.json");
        assertNotNull(filteredStudents);
        assertFalse(filteredStudents.isEmpty());

        //test that only students who have age more than 25 are added
        for(Student student : filteredStudents){
            assertTrue(student.getAge() > 25);
        }
        System.out.println("✅ Test Passed");
    }
}
