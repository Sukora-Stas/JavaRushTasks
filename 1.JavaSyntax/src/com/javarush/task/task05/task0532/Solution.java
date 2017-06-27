package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int a;

        int maximum= Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(reader.readLine());
            if (maximum < a) {
                maximum = a;
            }
        }




        //напишите тут ваш код

        System.out.println(maximum);
    }
}
