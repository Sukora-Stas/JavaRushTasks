package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        map.put("Сукора","Станислав");
        map.put("Твав","ывам");
        map.put("фвыпф","ывапф");
        map.put("фап","Станислав");
        map.put("Сукора","вапми");
        map.put("фвап","Станислав");
        map.put("Сукора","ывфва");
        map.put("ываы","Станислав");
        map.put("Сукора","ывпвар");
        map.put("ыва","фвыа");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
