package com.javarush.task.task10.task1012;
/*
Количество букв
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < abcArray.length; i++) {
            hashMap.put(abcArray[i], 0);
        }

        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            char[] chars = s.toLowerCase().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (hashMap.containsKey(chars[j]))
                    hashMap.put(chars[j], hashMap.get(chars[j]) + 1);
            }
        }

        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + hashMap.get(abcArray[i]));
        }

    }
}
