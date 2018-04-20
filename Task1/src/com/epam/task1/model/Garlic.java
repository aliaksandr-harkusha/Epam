package com.epam.task1.model;

public class Garlic extends Vegetable {
    public Garlic() {
        super();
    }

    public Garlic(double calorific, double weight) {
        super(calorific, weight);
    }

    @Override
    public String toString() {
        return "Garlic" + "{calorific=" + getCalorific() + ", weight=" + getWeight() + "}";
    }
}
