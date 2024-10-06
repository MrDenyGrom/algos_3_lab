package org.example.model;

import java.util.Random;
import java.util.Scanner;

class SystemSimulation {
    private final MyQueue<Task> queue = new MyQueue<>();
    private final MyStack<Task> stack = new MyStack<>();
    private int time = 0;
    private boolean p0Busy = false;
    private boolean p1Busy = false;
    private Task currentP0Task = null;
    private Task currentP1Task = null;

    public void addTask(Task task) {
        queue.enqueue(task);
        System.out.println("Задача " + task.id + " добавлена в очередь. Время поступления: " + task.timeArrival);
    }

    public Task createTaskFromInput(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите время обработки процессором P0 для задачи " + id + ": ");
        int timeP0 = scanner.nextInt();
        System.out.println("Введите время обработки процессором P1 для задачи " + id + ": ");
        int timeP1 = scanner.nextInt();
        System.out.println("Введите частоту появления задачи (в шагах) для задачи " + id + ": ");
        int arrivalFrequency = scanner.nextInt();
        return new Task(id, time, timeP0, timeP1, arrivalFrequency);
    }

    public void processP0() {
        if (!p0Busy && !queue.isEmpty()) {
            currentP0Task = queue.dequeue();
            p0Busy = true;
            System.out.println("Процессор P0 начал обработку задачи " + currentP0Task.id + " (время обработки: " + currentP0Task.timeP0 + ")");
        }
        if (p0Busy) {
            currentP0Task.timeP0--;
            if (currentP0Task.timeP0 == 0) {
                System.out.println("Процессор P0 завершил обработку задачи " + currentP0Task.id );
                stack.push(currentP0Task);
                p0Busy = false;
            }
        }
    }

    public void processP1() {
        if (!p1Busy && !stack.isEmpty()) {
            currentP1Task = stack.pop();
            p1Busy = true;
            System.out.println("Процессор P1 начал обработку задачи " + currentP1Task.id + " (время обработки: " + currentP1Task.timeP1 + ")");
        }
        if (p1Busy) {
            currentP1Task.timeP1--;
            if (currentP1Task.timeP1 == 0) {
                System.out.println("Процессор P1 завершил обработку задачи " + currentP1Task.id);
                p1Busy = false;
            }
        }
    }

    public void step() {
        System.out.println("Текущее время: " + time);
        System.out.println("Состояние очереди F: " + queue.toString());
        System.out.println("Состояние стека S: " + stack.toString());
        processP0();
        processP1();
        time++;
        System.out.println("-----");
    }

    public void runSimulation(int totalSteps, boolean manualInput) {
        int taskId = 1;
        Random rand = new Random();
        int nextTaskArrival = 0;

        for (int i = 0; i < totalSteps; i++) {
            if (i == nextTaskArrival) {
                Task newTask;
                if (manualInput) {
                    newTask = createTaskFromInput(taskId++);
                    nextTaskArrival = i + newTask.arrivalFrequency;
                } else {
                    int timeP0 = rand.nextInt(10) + 1;
                    int timeP1 = rand.nextInt(10) + 1;
                    int arrivalFrequency = rand.nextInt(10) + 1;
                    newTask = new Task(taskId++, time, timeP0, timeP1, arrivalFrequency);
                    nextTaskArrival = i + arrivalFrequency;
                }
                addTask(newTask);
            }
            step();
        }
    }
}