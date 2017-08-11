package com.javarush.task.task20.task2026;

import java.util.Map;
import java.util.TreeMap;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        Map<Byte, Integer> map = new TreeMap<>();

        for (int x = 0; x < a.length; x++)
            for (int y = 0; y < a[0].length; y++) {
                byte summa = 0;
                if (a[x][y] == 0) continue;
                summa += (x - 1 >= 0 && y - 1 >= 0) ? a[x - 1][y - 1] : 0;                  // a[x - 1][y - 1]
                summa += (y - 1 >= 0) ? a[x][y - 1] : 0;                                    // a[x][y - 1]
                summa += (x + 1 < a.length && y - 1 >= 0) ? a[x + 1][y - 1] : 0;            // a[x + 1][y - 1]
                summa += (x - 1 >= 0) ? a[x - 1][y] : 0;                                    // a[x - 1][y]
                summa += a[x][y];                                                           // a[x][y]
                summa += (x + 1 < a.length) ? a[x + 1][y] : 0;                              // a[x + 1][y]
                summa += (x - 1 >= 0 && y + 1 < a[0].length) ? a[x - 1][y + 1] : 0;         // a[x - 1][y + 1]
                summa += (y + 1 < a[0].length) ? a[x][y + 1] : 0;                           // a[x][y + 1]
                summa += (x + 1 < a.length && y + 1 < a[0].length) ? a[x + 1][y + 1] : 0;   // a[x + 1][y + 1]

                if (map.containsKey(summa))
                    map.put(summa, map.get(summa) + 1);
                else
                    map.put(summa, 1);
            }

        int rectangleCount = 0;
        rectangleCount += map.containsKey((byte) 4) ? map.get((byte) 4) / 4 : 0;
        rectangleCount += map.containsKey((byte) 2) ? map.get((byte) 2) / 2 : 0;
        rectangleCount += map.containsKey((byte) 1) ? map.get((byte) 1) : 0;

        return rectangleCount;
    }
}
