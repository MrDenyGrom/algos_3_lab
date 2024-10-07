package org.example.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemSimulation system = new SystemSimulation();

        System.out.println("Введите количество шагов симуляции: ");
        int totalSteps = scanner.nextInt();

        int inputChoice;
        do {
            System.out.println("Вводить задачи вручную? (1 - да, 0 - нет): ");
            inputChoice = scanner.nextInt();
            if (inputChoice != 0 && inputChoice != 1) {
                System.out.println("Нунжо вводить только 0 или 1. Попробуйте еще раз.");
            }

        } while (inputChoice != 0 && inputChoice != 1);


        boolean manualInput = inputChoice == 1;

        system.runSimulation(totalSteps, manualInput);
    }
}