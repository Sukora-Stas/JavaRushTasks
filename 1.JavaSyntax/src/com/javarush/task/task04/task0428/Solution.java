package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 3; j++) {
            int a = Integer.parseInt(reader.readLine());
            if (getTrue(a)) {
                i++;
            }
        }
        System.out.println(i);
    }

    public static boolean getTrue(int a) {
        return a >= 0;
    }


}
