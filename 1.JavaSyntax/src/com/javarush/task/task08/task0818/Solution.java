package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Sim", 205);
        map.put("Tom", 550);
        map.put("Arbus", 356);
        map.put("Baby", 700);
        map.put("Cat", 520);
        map.put("Dog", 452);
        map.put("Eat", 120);
        map.put("Food", 856);
        map.put("Gevey", 452);
        map.put("Hugs", 589);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>();

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() < 500) {
                copy.put(m.getKey(), m.getValue());
            }
        }

        for (Map.Entry<String, Integer> m : copy.entrySet()) {
            map.remove(m.getKey());
        }


    }

    public static void main(String[] args) {

    }
}