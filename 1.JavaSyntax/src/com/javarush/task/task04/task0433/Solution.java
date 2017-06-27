package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        boolean m = true, n = true;
        int n1 = 10, m1 = 10;

        while (m) {
            while (n) {
                System.out.print("S");
                n1--;
                if (n1 == 0) {
                    n = false;
                }
            }
            n1=10;
            n = true;
            System.out.println();
            m1--;
            if (m1 == 0) {
                m = false;
            }
        }
    }
}
