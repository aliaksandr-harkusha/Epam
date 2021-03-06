package com.epam.task1.manager;

import com.epam.task1.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaladManager implements Manageable {
    //лучше создай класс например Salad - в пакете model
    //который будет инкапсулировать эту коллекцию, с методами get,set,add,getSize - например
    //и здесь просто создавай объект этого класса
    private List<Vegetable> vegetables;

    public SaladManager() {
        this.vegetables = new ArrayList<>();
        createDummySalad();
    }

    private void createDummySalad() {
        vegetables.add(new Carrot());
        vegetables.add(new Garlic());
        vegetables.add(new Onion());
        vegetables.add(new Potato());
        vegetables.add(new Tomato());
    }

    public double countCalorific() {
        int count = 0;
        for (Vegetable vegetable : vegetables) {
            count += vegetable.getCalorific();
        }
        return count;
    }

    public void sort() {
        Collections.sort(vegetables);
    }

    public List<Vegetable> find(int beginValue, int endValue) {
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable vegetable : vegetables) {
            if (vegetable.getCalorific() > beginValue
                    && vegetable.getCalorific() < endValue) {
                result.add(vegetable);
            }
        }
        return result;
    }

    public Vegetable getVegetable(int index) {
        return vegetables.get(index);
    }

    public int getVegetablesCount() {
        return vegetables.size();
    }

    public void printVegetables() {
        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable);
        }
    }
}
