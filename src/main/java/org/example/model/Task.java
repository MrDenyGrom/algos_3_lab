package org.example.model;

class Task {
    int id;
    int timeArrival;
    int timeP0;
    int timeP1;
    int arrivalFrequency;

    public Task(int id, int timeArrival, int timeP0, int timeP1, int arrivalFrequency) {
        this.id = id;
        this.timeArrival = timeArrival;
        this.timeP0 = timeP0;
        this.timeP1 = timeP1;
        this.arrivalFrequency = arrivalFrequency;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", timeP0=" + timeP0 +
                ", timeP1=" + timeP1 +
                ", arrivalFrequency=" + arrivalFrequency +
                "} \n";
    }
}