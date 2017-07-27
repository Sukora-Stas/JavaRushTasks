package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {


    }

    static {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());
    }

    public static class thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class thread4 extends Thread implements Message {
        @Override
        public void run() {
            showWarning();
        }

        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (Exception e) {
            }
        }
    }

    public static class thread5 extends Thread {


        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String str;
            while (true) {
                try {
                    str = reader.readLine();
                    if (str.equals("N")) {
                        System.out.println(sum);

                        break;
                    } else {
                        sum += Integer.parseInt(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}