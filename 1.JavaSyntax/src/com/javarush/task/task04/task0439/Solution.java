package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

String s = reader.readLine();

        for (int i = 0; i < 10; i++) {
            System.out.println(s+" любит меня.");
        }

    }
}
