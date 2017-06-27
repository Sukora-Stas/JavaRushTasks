package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean t = true;
        int sum = 0;
        while (t) {
            int a = Integer.parseInt(reader.readLine());
            sum += a;
            if (a == -1) {
                System.out.println(sum);
                t=false;
            }

        }

    }
}
