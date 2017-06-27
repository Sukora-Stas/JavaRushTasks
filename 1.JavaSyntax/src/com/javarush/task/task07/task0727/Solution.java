package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
        int sz = list.size();
        for (int i = sz - 1; i >= 0; i--) {
            String s = list.get(i);
            int size = list.get(i).length();

            list.remove(i);
            if (size % 2 == 0) {

                list.add(s + " " + s);
            } else {
                list.add(s + " " + s + " " + s);
            }

        }


        ArrayList<String> listUpperCase = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            listUpperCase.add(s.toUpperCase());
        }


        for (int i = listUpperCase.size() - 1; i >= 0; i--) {
            System.out.println(listUpperCase.get(i));
        }
    }
}
