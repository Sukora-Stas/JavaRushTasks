package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int k = 1;
        while (k<=10){
            int n = 1;
            while (n<=10){
                System.out.print(n * k + " ");
                n++;
            }
            k++;
            System.out.println();
        }

    }
}
