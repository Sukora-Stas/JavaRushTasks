package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        list.add(1,"именно");
        list.add(3,"именно");
        list.add(5,"именно");

//        for (int i = 0; i < list.size(); i++) {
//            list.add(i + 1, "именно");
//            System.out.println(list.get(i));
//        }

        for (String s : list) {
            System.out.println(s);
        }


    }
}
