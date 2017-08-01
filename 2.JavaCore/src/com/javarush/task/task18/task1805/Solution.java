package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fStream = new FileInputStream(reader.readLine());

        Set<Integer> list = new TreeSet<Integer>();
        while (fStream.available() > 0){
            int data = fStream.read();
            list.add(data);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        fStream.close();
        reader.close();


    }
}
