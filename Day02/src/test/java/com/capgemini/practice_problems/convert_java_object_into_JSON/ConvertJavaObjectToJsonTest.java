package com.capgemini.practice_problems.convert_java_object_into_JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertJavaObjectToJsonTest {

    @Test
    void convertJavaObjectsTest1(){
        JSONArray jsonArray = new JSONArray();
        ConvertJavaObjectToJson.convertToJson(jsonArray, new Car("Maserati", 2000, 30000000));

        JSONObject jsonObject = jsonArray.getJSONObject(0);

        assertEquals("Maserati", jsonObject.getString("name"));
        assertEquals(30000000,jsonObject.getDouble("price"));
    }
}
