package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int number = Integer.parseInt(reader.readLine());
            list.add(number);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 == 0) {
                list1.add(list.get(i));
            }
            if (list.get(i) % 2 == 0) {
                list2.add(list.get(i));
            }
            if (list.get(i) % 3 != 0 & list.get(i) % 2 != 0) {
                list3.add(list.get(i));
            }
        }
        printList(list1);
        printList(list2);
        printList(list3);

    }


    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer s : list) {
            System.out.println(s);
        }

    }
}
