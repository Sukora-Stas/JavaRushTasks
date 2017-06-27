package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a1 = 0, b1 = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int a = Integer.parseInt(reader.readLine());
            if (a != 0) {
                if (a < 0) {
                    a1++;
                } else b1++;
            }
        }
        System.out.println("количество отрицательных чисел: " + a1);
        System.out.println("количество положительных чисел: " + b1);


    }
}
