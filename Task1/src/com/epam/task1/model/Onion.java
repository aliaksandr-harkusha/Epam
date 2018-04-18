package com.epam.task1.model;

public class Onion extends Vegetable {
    public Onion() {
        super();
    }

    public Onion(double calorific, double weight) {
        super(calorific, weight);
    }

    @Override
    public String toString() {
        return "Onion" + "{calorific=" + getCalorific() + ", weight=" + getWeight() + "}";
    }
}
