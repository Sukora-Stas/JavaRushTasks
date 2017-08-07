package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (in.available() > 0) {
            String line = String.valueOf((char)in.read());
            char[] chars = line.toCharArray();
            for (char c : chars) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> mp : map.entrySet()) {
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
        in.close();
    }
}
