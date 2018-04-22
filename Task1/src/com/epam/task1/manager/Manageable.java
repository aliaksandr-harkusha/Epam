package com.epam.task1.manager;

import com.epam.task1.model.Vegetable;

import java.util.List;

//переименуй лучше в какой-нибудь SaladService или ISaladManager
//а то Manageable - не информативное название
public interface Manageable {
    double countCalorific();

    void sort();

    List<Vegetable> find(int beginValue, int endValue);

    Vegetable getVegetable(int index);

    int getVegetablesCount();

    void printVegetables();
}
