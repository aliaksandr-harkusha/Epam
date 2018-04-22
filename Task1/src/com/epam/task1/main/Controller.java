package com.epam.task1.main;

import com.epam.task1.manager.SaladManager;
import com.epam.task1.model.Vegetable;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//я думаю этот класс избыточен
//все общение с пользователем следует выносить в main () метод, 
//либо в класс, где содержится main () метод
//а так этот класс больше на view похож, а не на Controller
public class Controller {
    //все буквы большие - только для констант
    private StringBuilder MENU;
    private SaladManager manager;

    public Controller(SaladManager manager) {
        initializeMenu();
        this.manager = manager;
    }

    private void initializeMenu() {
        MENU = new StringBuilder();
        MENU.append("---------------------\n")
                .append("1 - Create salad\n")
                .append("2 - Count calorific\n")
                .append("3 - Sort by weight\n")
                .append("4 - Find by calorific\n")
                .append("5 - Quit\n")
                .append("---------------------\n\n")
                .append("> ");
    }

    public void start() {
        //вместо этих ридеров - используй лучше Scanner(System.in)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (true) {
                System.out.print(MENU);
                input = reader.readLine();
                if (input.equals(Modes.QUIT)) break;
                handleInput(input);
            }
        } catch (IOException e) {
          //никогда не оставляй catch-блок - это грубая ошибка
          //пиши хотя бы что-то типа: System.out.println("IOException has been thrown ... " + e)
          //  e.printStackTrace(); - не всегда информативен
        }
    }

    private void handleInput(String input) {
        switch (input) {
            case Modes.CREATE:
                createSalad();
                break;
            case Modes.COUNT:
                countCalorific();
                break;
            case Modes.SORT:
                sort();
                break;
            case Modes.FIND:
                find();
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }

    private void createSalad() {
        try (BufferedReader reader = new BufferedReader(new FileReader("parameters.txt"))) {
            int vegetablesCount = manager.getVegetablesCount();
            for (int i = 0; i < vegetablesCount; i++) {
                Vegetable current = manager.getVegetable(i);
                initializeVegetable(current, reader.readLine());
            }
            printSalad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeVegetable(Vegetable vegetable, String line) {
        int parametersCount = 2;
        double[] parameters = new double[parametersCount];

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
        manager.printVegetables();
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
