package com.capgemini.practice_problems.convert_java_object_into_JSON;

import org.json.JSONArray;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Maserati", 2000, 30000000);
        Car car2 = new Car("Tata-Nano", 2004, 250000);

        JSONArray jsonArray = new JSONArray();
        ConvertJavaObjectToJson.convertToJson(jsonArray,car1);
        ConvertJavaObjectToJson.convertToJson(jsonArray,car2);
        System.out.println(jsonArray.toString(4));
    }
}
