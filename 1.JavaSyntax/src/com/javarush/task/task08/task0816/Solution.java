package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        int d = 1980;
        for (int i = 0; i < 9; i++) {
            map.put("Stallone" + i, new Date("JUNE 1 " + d++));
            map.put("Stallone", new Date("MAY 16 1997"));
        }
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        HashMap<String, Date> newMap = new HashMap<>();

        for (Map.Entry<String, Date> pair : map.entrySet()) {
            String key = pair.getKey();

            int num = pair.getValue().getMonth();
            if (num == 5 || num == 6 || num == 7) {
                newMap.put(pair.getKey(), pair.getValue());
            }
        }
        for (Map.Entry pair : newMap.entrySet()) {
            map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

        removeAllSummerPeople(createMap());
    }
}
