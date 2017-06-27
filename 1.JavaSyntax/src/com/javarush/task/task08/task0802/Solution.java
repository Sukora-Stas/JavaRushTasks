package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> set = new HashMap<>();

        set.put("арбуз", "ягода");
        set.put("банан", "трава");
        set.put("вишня", "ягода");
        set.put("груша", "фрукт");
        set.put("дыня", "овощ");
        set.put("ежевика", "куст");
        set.put("жень-шень", "корень");
        set.put("земляника", "ягода");
        set.put("ирис", "цветок");
        set.put("картофель", "клубень");

        for(Map.Entry<String,String> pair  : set.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
