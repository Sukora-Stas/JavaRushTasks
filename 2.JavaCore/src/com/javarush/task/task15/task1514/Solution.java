package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    static {
        labels.put(1.0,"s");
        labels.put(2.0,"w");
        labels.put(3.0,"e");
        labels.put(4.0,"r");
        labels.put(5.0,"t");




    }
}
