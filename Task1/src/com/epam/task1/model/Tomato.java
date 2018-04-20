package com.epam.task1.model;

public class Tomato extends Vegetable {
    public Tomato() {
        super();
    }

    public Tomato(double calorific, double weight) {
        super(calorific, weight);
    }

    @Override
    public String toString() {
        return "Tomato" + "{calorific=" + getCalorific() + ", weight=" + getWeight() + "}";
    }
}
