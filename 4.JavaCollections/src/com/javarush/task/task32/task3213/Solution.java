package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        int a;
        StringBuffer res = new StringBuffer();

        try {
            while ((a = reader.read()) != -1) {
                res.append(Character.toString((char) (a + key)));
            }
        } catch (Exception e) {
            return new String();
        }

        return res.toString();
    }

}
