package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        boolean v = false, x = false;
        int size = 0;
        for (int i=0;i<args .length;++i) {
            String arg = args[i];
            if (arg.equals("-v")) {
                v = true;
            } else if (arg.equals("-size")) {
                size = Integer.parseInt(args[++i]);//да, здесь может быть ArrayIndexOutOfBoundsException
            } else if (arg.equals("-x")) {
                x = true;
            }
        }
        System.err.println("v = " + v);
        System.err.println("x = " + x);
        System.err.println("size = " + size);

    }
}
