package com.capgemini.practice_problems.convert_list_of_objects_into_json_array;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("Om Tiwari", 22, "tiwariom899@gmail.com"),
                new Student("Harsh veer singh", 95, "harshveerthakur69@gmail.com"),
                new Student("Durges Kushwaha", 23, "durgesh48@gamil.com"));

        ConvertListToJson.convertToJson(list);
    }
}
