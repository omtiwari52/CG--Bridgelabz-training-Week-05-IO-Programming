package com.capgemini.practice_problems.convert_list_of_objects_into_json_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertListToJsonTest {

    @Test
    void convertListToJsonTest1(){

        List<Student> list = Arrays.asList(new Student("Om Tiwari", 22, "tiwariom899@gmail.com"),
                new Student("Harsh veer singh", 95, "harshveerthakur69@gmail.com"),
                new Student("Durges Kushwaha", 23, "durgesh48@gamil.com"));

        String jsonArray = ConvertListToJson.convertToJson(list);

        assert jsonArray != null;
        assertTrue(jsonArray.contains("Om Tiwari"));
        assertTrue(jsonArray.contains("harshveerthakur69@gmail.com"));
        assertTrue(jsonArray.contains("Durges Kushwaha"));
        System.out.println("✅ Test1 Passed");
    }
}
