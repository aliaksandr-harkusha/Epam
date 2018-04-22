package com.epam.task1.main;

import com.epam.task1.manager.SaladManager;

//этот класс лучше переименовать в Controller, Runner или Starter
//пакет лучше переименовать также (в Controller, Runner или Starter) только с маленикой буквы
public class Chef {
    public static void main(String[] args) {
        Controller controller = new Controller(new SaladManager());
        controller.start();
    }
}
