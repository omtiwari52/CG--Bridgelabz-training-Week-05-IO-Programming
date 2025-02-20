package com.capgemini.practice_problems.merge_two_json_objects;

import org.json.JSONObject;

public class Merge {

    //method to merge two json objects and returns a merged json object
    public static JSONObject merge(JSONObject obj1, JSONObject obj2){

        for(String key : obj2.keySet()){
            obj1.put(key, obj2.get(key));
        }
        return obj1;
    }
}
