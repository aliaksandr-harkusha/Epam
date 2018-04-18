package com.epam.task1.manager;

import com.epam.task1.model.Vegetable;

import java.util.List;

public interface Manageable {
    double countCalorific();

    void sort();

    List<Vegetable> find(int beginValue, int endValue);
}
