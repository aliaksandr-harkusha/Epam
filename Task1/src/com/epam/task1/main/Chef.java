package com.epam.task1.main;

import com.epam.task1.manager.SaladManager;

public class Chef {
    public static void main(String[] args) {
        Controller controller = new Controller(new SaladManager());
        controller.start();
    }
}
