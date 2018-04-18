package com.epam.task1.model;

public class Potato extends Vegetable {
    public Potato() {
        super();
    }

    public Potato(double calorific, double weight) {
        super(calorific, weight);
    }

    @Override
    public String toString() {
        return "Potato" + "{calorific=" + getCalorific() + ", weight=" + getWeight() + "}";
    }
}
