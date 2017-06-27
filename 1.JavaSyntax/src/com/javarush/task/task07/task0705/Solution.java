package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr = new int[20];

        int[] a1 = new int[10];
        int[] a2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < a1.length; i++) {
            a1[i] = arr[i];
            a2[i] = arr[10 + i];
        }

        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }
    }
}
