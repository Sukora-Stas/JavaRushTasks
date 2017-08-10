package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static TreeMap<String, Double> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];

        BufferedReader file = new BufferedReader(new FileReader(filename));

        while (file.ready()) {
            String s = file.readLine();
            String[] strs = s.split(" ");
            addMap(strs[0], Double.parseDouble(strs[1]));
        }

        file.close();

        //show
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            // Хотелось как в условии задачи отформатировать, а нет валидатор думает иначе.
            //System.out.println(String.format("%s %.2f", pair.getKey(), pair.getValue()));
            System.out.println(pair.getKey() + " " + pair.getValue()); // - Так проходит
        }
    }

    private static void addMap(String name, Double value) {
        if (!map.containsKey(name))
            map.put(name, value);
        else
            map.put(name, map.get(name) + value);
    }
}
