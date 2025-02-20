package com.capgemini.practice_problems.convert_java_object_into_JSON;

public class Car {

    //define attributes of car
    private String carName;
    private int year;
    private double price;

    //constructor
    public Car(String carName, int year, double price){
        this.carName = carName;
        this.year = year;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getCarName() {
        return carName;
    }
}
