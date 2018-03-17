package com.javarush.task.task36.task3610;

import java.util.Map;

/* 
MyMultiMap
*/

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyMultiMap<>(3);
        for (int i = 0; i < 7; i++) {
            map.put(i, i);
        }
        map.put(5, 56);
        map.put(5, 57);
        System.out.println(map.put(5, 58));             //expected: 57

        System.out.println(map);                        //expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=56, 57, 58, 6=6}
        System.out.println(map.size());                 //expected: size = 9

        System.out.println(map.remove(5));              //expected: 56
        System.out.println(map);                        //expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=57, 58, 6=6}
        System.out.println(map.size());                 //expected: size = 8

        System.out.println(map.keySet());               //expected: [0, 1, 2, 3, 4, 5, 6]
        System.out.println(map.values());               //expected: [0, 1, 2, 3, 4, 57, 58, 6]

        System.out.println(map.containsKey(5));         //expected: true
        System.out.println(map.containsValue(57));      //expected: true
        System.out.println(map.containsValue(7));       //expected: false
    }
}