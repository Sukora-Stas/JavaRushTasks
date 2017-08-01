package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String str = reader.readLine();
////        reader.close();
//        Map<Integer, Integer> map = new HashMap<>();
//        try (InputStream file = new FileInputStream(str);) {
//            while (file.read() > 0) {
//                int baite = file.read();
//                Integer freque = map.get(baite);
//                map.put(baite, freque == null ? 1 : freque + 1);
//            }
//        }
//        map = sortByValue(map);
//        for (Map.Entry<Integer, Integer> pair :
//                map.entrySet()) {
//            for (int i = 0; i < pair.getValue(); i++) {
//                System.out.print(pair.getKey() + " ");
//            }
//        }
//    }
//
//    public static <K, V extends Comparable<? super V>> Map<K, V>
//    sortByValue(Map<K, V> map) {
//        List<Map.Entry<K, V>> list =
//                new LinkedList<>(map.entrySet());
//        list.sort(new Comparator<Map.Entry<K, V>>() {
//            @Override
//            public int compare(Map.Entry<K, V> o2, Map.Entry<K, V> o1) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//        Map<K, V> result = new LinkedHashMap<>();
//        for (Map.Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//        return result;


        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String filename = r.readLine();
        FileInputStream in = new FileInputStream(filename);

        int[] bytes = new int[256];
        try {
            if (in.available() > 0) {
                while (in.available() > 0) {
                    bytes[in.read()]++;
                }
                in.close();
            } else {
                in.close();
                return;
            }
            in.close();
        } catch (Exception e) {
            in.close();

        }


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != 0)
                list.add(bytes[i]);
        }
        int min = Collections.min(list);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min)
                System.out.print(i + " ");
        }

        in.close();

    }
}