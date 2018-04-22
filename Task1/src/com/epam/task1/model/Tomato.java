package com.epam.task1.model;

//ни один из твоих производных классов - не содержит дополнительных полей
//это только конструкторы и toString()
//в таком случае - наследование - не оправдано
//тебе лучше завести какой-то enum - где будут просто типы или названия этих овощей
//и в классе Vegetable - создать поле name или type - нового enum-а
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
