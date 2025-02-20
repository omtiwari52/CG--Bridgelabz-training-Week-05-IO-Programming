package com.capgemini.practice_problems.merge_two_json_objects;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {

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

        System.out.println(Merge.merge(obj1,obj2).toString(4));
    }
}
