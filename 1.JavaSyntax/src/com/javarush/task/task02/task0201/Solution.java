package com.javarush.task.task02.task0201;

/* 
Реализуем метод print
*/
public class Solution {
    public static void main(String[] args) {
        print("Java easy to learn!");
    }

    public static void print(String s) {
        for (int i = 0; i < 4; i++) {
            System.out.println(s);
        }
    }
}
