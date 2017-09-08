package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double t = Double.parseDouble(reader.readLine());

        t = t % 60 % 5;
        if (t >= 0) {
            if (t <= 3.0) {
                System.out.println("зелёный");
            } else if (t > 3.0 && t <= 4.0) {
                System.out.println("желтый");
            } else if (t<=5.0){
                System.out.println("красный");
            }
        }

    }
}