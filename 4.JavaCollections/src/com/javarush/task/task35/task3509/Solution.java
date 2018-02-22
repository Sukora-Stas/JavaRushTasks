package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
        //ArrayList<Integer> tst = newArrayList (new Integer(10), new Integer(20));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> res = new ArrayList<>();
        for (T elm : elements)
            res.add(elm);

        return res;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> res = new HashSet<>();
        for (T elm : elements)
            res.add(elm);

        return res;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size())
            throw new IllegalArgumentException();

        HashMap<K, V> res = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            res.put(keys.get(i), values.get(i));
        }

        return res;
    }
}
