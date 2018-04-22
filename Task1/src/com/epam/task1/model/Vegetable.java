package com.epam.task1.model;

import java.util.Objects;

//если удалиши производные классы - этот класс перестанет быть абстрактным
public abstract class Vegetable implements Comparable<Vegetable> {
    private double calorific;
    private double weight;

    public Vegetable() {

    }

    public Vegetable(double calorific, double weight) {
        this.calorific = calorific;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable v = (Vegetable) o;
        return this.calorific == v.calorific && this.weight == v.calorific;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calorific, weight);
    }

    @Override
    public String toString() {
        return "Vegetable" + "{calorific=" + calorific + ", weight=" + weight + "}";
    }

    @Override
    public int compareTo(Vegetable vegetable) {
        return Double.compare(weight, vegetable.weight);
    }

    public double getCalorific() {
        return calorific;
    }

    public void setCalorific(double calorific) {
        this.calorific = calorific;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
