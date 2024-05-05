package com.example.myfistapp;

public class ModelClass {
    private int id;
    private String name;
    private double protein;
    private double calories;
    private double carbs;

    public ModelClass(int id, String name, double protein, double calories, double carbs) {
        this.id = id;
        this.name = name;
        this.protein = protein;
        this.calories = calories;
        this.carbs = carbs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
}
