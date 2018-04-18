package com.epam.task1.model;

public class Carrot extends Vegetable {
    public Carrot() {
        super();
    }

    public Carrot(double calorific, double weight) {
        super(calorific, weight);
    }

    @Override
    public String toString() {
        return "Carrot" + "{calorific=" + getCalorific() + ", weight=" + getWeight() + "}";
    }
}
