package com.epam.task1.main;

import com.epam.task1.manager.SaladManager;
import com.epam.task1.model.Vegetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private static final String MENU =
            "---------------------\n" +
                    "1 - Create salad\n" +
                    "2 - Count calorific\n" +
                    "3 - Sort by weight\n" +
                    "4 - Find by calorific\n" +
                    "5 - Quit\n" +
                    "---------------------\n\n" +
                    "> ";

    private SaladManager manager;

    public Controller(SaladManager manager) {
        this.manager = manager;
        start();
    }

    private void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (true) {
                System.out.print(MENU);
                input = reader.readLine();
                if (input.equals("5")) break;
                handleInput(input);
            }
        } catch (IOException e) {

        }
    }

    private void handleInput(String input) {
        switch (input) {
            case "1":
                createSalad();
                break;
            case "2":
                countCalorific();
                break;
            case "3":
                sort();
                break;
            case "4":
                find();
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }

    private void createSalad() {
        try (BufferedReader reader = new BufferedReader(new FileReader("parameters.txt"))) {
            int countOfVegetables = 5;
            for (int i = 0; i < countOfVegetables; i++) {
                initializeVegetable(manager.getVegetables().get(i), reader.readLine());
            }
            printSalad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeVegetable(Vegetable vegetable, String line) {
        int countOfParameters = 2;
        double[] parameters = new double[countOfParameters];

        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(line);

        int k = 0;
        while (m.find()) {
            parameters[k++] = Double.parseDouble(m.group());
        }

        vegetable.setCalorific(parameters[0]);
        vegetable.setWeight(parameters[1]);
    }

    private void printSalad() {
        System.out.println("Salad:");
        for (Vegetable vegetable : manager.getVegetables()) {
            System.out.println(vegetable);
        }
        System.out.println();
    }

    private void countCalorific() {
        int calorific = (int) manager.countCalorific();
        System.out.println("Calorific = " + calorific + "\n");
    }

    private void sort() {
        manager.sort();
        printSalad();
    }

    private void find() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("begin: ");
            String begin = reader.readLine();
            int beginValue = (int) Double.parseDouble(begin);
            System.out.print("end: ");
            String end = reader.readLine();
            int endValue = (int) Double.parseDouble(end);
            System.out.println(Arrays.toString(manager.find(beginValue, endValue).toArray()));
            System.out.println();
        } catch (Exception e) {
            System.out.println("Incorrect input!");
        }
    }
}
