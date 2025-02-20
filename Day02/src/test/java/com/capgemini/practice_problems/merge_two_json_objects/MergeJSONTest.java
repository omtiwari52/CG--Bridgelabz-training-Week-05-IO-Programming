package com.capgemini.practice_problems.merge_two_json_objects;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeJSONTest {

    @Test
    void mergeTest1(){
        //create 1st json object
        JSONObject obj1 = new JSONObject();
        obj1.put("name1", "Om Tiwari");
        obj1.put("ID1", 115);
        obj1.put("Grade1", "A");

        //create 1st json object
        JSONObject obj2 = new JSONObject();
        obj2.put("name2", "Harsh veer");
        obj2.put("ID2", 68);
        obj2.put("Grade2", "F");

        JSONObject mergedObj = new JSONObject();
        mergedObj.put("name1", "Om Tiwari");
        mergedObj.put("ID1", 115);
        mergedObj.put("Grade1", "A");
        mergedObj.put("name2", "Harsh veer");
        mergedObj.put("ID2", 68);
        mergedObj.put("Grade2", "F");

        assertEquals(mergedObj.toString(), Merge.merge(obj1,obj2).toString());
        System.out.println("✅ Test Passed");
    }
}
