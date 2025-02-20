package com.capgemini.practice_problems.convert_java_object_into_JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConvertJavaObjectToJson {

    //method to convert java objects to Json
    public static void convertToJson(JSONArray jsonArray,Car car){
           JSONObject jsonObject = new JSONObject();
           jsonObject.put("name",car.getCarName());
           jsonObject.put("year",car.getYear());
           jsonObject.put("price",car.getPrice());

           jsonArray.put(jsonObject);
    }
}
