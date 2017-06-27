package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

public class Solution extends Thread{
    public static void main(String[] args) {
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //напишите тут ваш код
        }

        System.out.println("Бум!");
    }
}
