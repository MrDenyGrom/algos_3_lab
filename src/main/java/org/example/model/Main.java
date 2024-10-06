package org.example.model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemSimulation system = new SystemSimulation();

        System.out.println("Введите количество шагов симуляции: ");
        int totalSteps = scanner.nextInt();

        System.out.println("Вводить задачи вручную? (1 - да, 0 - нет): ");
        boolean manualInput = scanner.nextInt() == 1;

        system.runSimulation(totalSteps, manualInput);
    }
}