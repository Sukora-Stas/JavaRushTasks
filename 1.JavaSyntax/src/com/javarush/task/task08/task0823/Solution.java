package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] sp = s.split("\\b");
        if (s.length() > 1) {
            for (int i = 0; i < sp.length; i++) {
                System.out.print(sp[i].substring(0, 1).toUpperCase() + sp[i].substring(1));
            }
        }
        System.out.println();
        //напишите тут ваш код
    }
}
