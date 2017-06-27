package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //напишите тут ваш код
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(calendar.DAY_OF_MONTH);
//        int month = calendar.get(calendar.MONTH)+1;
//        int year = calendar.get(calendar.YEAR);
//
//        System.out.println(day + " " +month + " " + year);

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd MM yyyy");

        System.out.println(formatForDateNow.format(dateNow));
    }
}
