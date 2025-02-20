package com.capgemini.practice_problems.parse_json_and_filter;

public class Student {

    private String name;
    private int age;
    private String email;

    public Student(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "', email='" + email +"'}";

    }
}
