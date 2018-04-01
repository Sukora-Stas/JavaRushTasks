package com.javarush.task.task39.task3904;

import java.util.HashMap;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;
    static HashMap<Integer, Long> map = new HashMap<>();
    static {
        map.put(0, 1L);
        map.put(1, 1L);
        map.put(2, 2L);
        map.put(3, 4L);
    }

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
        if (n < 0)
            return 0;

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long fibonacciValue = ((countPossibleRunups(n - 3) + countPossibleRunups(n - 2))  + countPossibleRunups(n - 1));
            map.put(n, fibonacciValue);
            return fibonacciValue;
        }
    }
}

