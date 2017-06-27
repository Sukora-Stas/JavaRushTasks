package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Сукора"+i, "Станислав");

        }
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            Map.Entry value = (Map.Entry) stringStringEntry;
            if (value.getValue().equals(name)) {
                count++;
            }
        }

        //напишите тут ваш код
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            Map.Entry value = (Map.Entry) stringStringEntry;
            if (value.getKey().equals(lastName)) {
                count++;
            }
        }
        //напишите тут ваш код
        return count;

    }

    public static void main(String[] args) {

    }
}
