package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int a = Integer.MAX_VALUE;
        int b = 0;
        int indexmin = 0, indexmax = 0;

        for (int i = 0; i < 10; i++) {
            list.add((new BufferedReader(new InputStreamReader(System.in)).readLine()));
            if (b < list.get(i).length()) {
                b = list.get(i).length();
                indexmin = i;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (a > list.get(i).length()) {
                a = list.get(i).length();
                indexmax = i;
            }
        }
        System.out.println(list.get(Math.min(indexmax, indexmin)));


    }
}
