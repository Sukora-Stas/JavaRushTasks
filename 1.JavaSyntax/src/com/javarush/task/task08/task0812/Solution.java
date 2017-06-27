package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> combos = new ArrayList<>(); // количество подряд идущих одинаковых символов для каждой такой последовательности

        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }

        int combo = 1;

        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i).equals(arrayList.get(i + 1))) {
                combo++;
                if (i == 8) {
                    combos.add(combo);
                }
            } else {
                {
                    // если комбо (подряд идущий одинаковый второй символ) прервалось; иначе ничего нужно делать.
                    if (combo != 1) {
                        combos.add(combo);
                        combo = 1;
                    }
                }
            }

        }
        if (combos.size() == 0) {
            System.out.println(1);
        } else {
            System.out.println(findMaxIntInArrayList(combos));
        }
    }

    public static int findMaxIntInArrayList(ArrayList<Integer> arrayList) {
        int arraySize = arrayList.size();
        if (arraySize == 1) {
            return arrayList.get(0);
        }
        int currentMaxElement = arrayList.get(0);
        for (int i = 0; i < arraySize - 1; i++) {
            if (arrayList.get(i + 1) > currentMaxElement) {
                currentMaxElement = arrayList.get(i + 1);
            }
        }
        return currentMaxElement;
    }
}