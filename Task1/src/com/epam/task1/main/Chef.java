package com.epam.task1.main;

import com.epam.task1.manager.SaladManager;

import java.io.IOException;

public class Chef {
    public static void main(String[] args) {
        Controller controller = new Controller(new SaladManager());
    }
}
