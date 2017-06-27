package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код

        Iterator iterator =set.iterator();

        while (iterator.hasNext()){
            int a= (int) iterator.next();
            if(a>10){
                iterator.remove();
            }
        }
//        for (int i = set.size() - 1; i >= 0; i--) {
//            if (i > 10) {
//                if (set.contains(i)) {
//                    set.remove(i);
//                }
//            }
//        }
        return set;
    }

    public static void main(String[] args) {
//        System.out.println(removeAllNumbersMoreThan10(createSet()));
    }
}
