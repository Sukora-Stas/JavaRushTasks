package com.javarush.task.task02.task0214;

/* 
Минимум двух чисел
*/
public class Solution {
    public static int min(int a, int b) {
        //напишите тут ваш код
        int m;
        if (a > b) {
            m = b;
        } else m = a;
        return m;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(min(12, 33));
        System.out.println(min(-20, 0));
        System.out.println(min(-10, -20));
    }
}