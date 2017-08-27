package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread currentThread : threads) {
            switch (currentThread.getState()) {
                case NEW:
                    currentThread.start();
                    break;
                case RUNNABLE:
                    currentThread.isInterrupted();
                    break;
                case BLOCKED:
                    currentThread.interrupt();
                    break;
                case WAITING:
                    currentThread.interrupt();
                    break;
                case TIMED_WAITING:
                    currentThread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(currentThread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
