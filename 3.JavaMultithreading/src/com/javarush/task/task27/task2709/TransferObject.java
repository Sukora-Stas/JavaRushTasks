package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        if (!isValuePresent) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("interrupted Exception caught");
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;

    }

    public synchronized void put(int value) {
        if (isValuePresent) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println("interrupted Exception caught");
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();
    }
}
