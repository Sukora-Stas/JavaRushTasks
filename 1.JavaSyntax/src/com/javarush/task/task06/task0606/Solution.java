package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        for (int a = Integer.parseInt(s); a > 0; a /= 10) {
            int b = a % 10;
            if (b % 2 == 0) even++;
            if (b % 2 != 0) odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);


    }
}
