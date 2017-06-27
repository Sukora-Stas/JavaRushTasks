package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String s = reader.readLine();

        int sum = 0;
        while (true) {
            try {
                int a = Integer.parseInt(reader.readLine());
                sum += a;
            } catch (NumberFormatException e) {
                System.out.println(sum);
                break;

            }

        }

    }
}
