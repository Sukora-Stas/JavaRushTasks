package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int m = Integer.parseInt(s);

        if (m > 0) {
            System.out.println(m *= 2);
        } else if (m < 0) {
            System.out.println(m + 1);
        } else {
            System.out.println(0);
        }

    }

}