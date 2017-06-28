package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat DATE = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        Date Date = new Date(r.readLine());
        String mdy = DATE.format(Date);
        System.out.println(mdy.toUpperCase());

    }
}
