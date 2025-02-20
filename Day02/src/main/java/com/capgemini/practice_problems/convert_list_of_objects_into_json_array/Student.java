package com.capgemini.practice_problems.convert_list_of_objects_into_json_array;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    private String name;
    private int age;
    private String email;

    // Constructors
    public Student() {}  // Default constructor

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

