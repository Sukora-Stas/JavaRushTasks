package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());

        if (truue(a) && a % 2 == 0 && getSize(a).length == 1) {
            System.out.println("четное однозначное число");
        } else if (truue(a) && a % 1 == 0 && getSize(a).length == 1) {
            System.out.println("нечетное однозначное число");
        } else if (truue(a) && a % 2 == 0 && getSize(a).length == 2) {
            System.out.println("четное двузначное число");
        } else if (truue(a) && a % 1 == 0 && getSize(a).length == 2) {
            System.out.println("нечетное двузначное число");
        } else if (truue(a) && a % 2 == 0 && getSize(a).length == 3) {
            System.out.println("четное трехзначное число");
        } else if (truue(a) && a % 1 == 0 && getSize(a).length == 3) {
            System.out.println("нечетное трехзначное число");
        }
    }

    public static boolean truue(int a) {
        if (a >= 1 && a <= 999) {
            return true;
        } else {
            return false;
        }
    }

    public static char[] getSize(int a) {
        String str = Integer.toString(a);
        char[] myCharArray = str.toCharArray();

        return myCharArray;
    }
}
