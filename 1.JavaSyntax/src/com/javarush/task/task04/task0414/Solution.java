package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sYear = reader.readLine();
        int year = Integer.parseInt(sYear);

        GregorianCalendar gcal = new GregorianCalendar();
        if (gcal.isLeapYear(year)) System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
    }
}