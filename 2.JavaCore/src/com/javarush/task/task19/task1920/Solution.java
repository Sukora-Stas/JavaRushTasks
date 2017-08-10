package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        double max = Double.MIN_VALUE;
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = strs[0];
            double value = Double.parseDouble(strs[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(strs[0]) + value);
            } else
                map.put(key, value);
        }
        fileReader.close();

        //Max
        for (Double a : map.values())
            if (max < a)
                max = a;

        //show
        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
    }
}
