package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int itt = 0;
        while (true) {
            int a = Integer.parseInt(reader.readLine());
            if (itt == 0 && a == -1) {
                sum = a;
                a = 0;
            }

            if (a == -1) {
                sum = sum / itt;
                System.out.println(sum);
                break;
            }

            itt++;
            sum += a;
        }

    }
}

