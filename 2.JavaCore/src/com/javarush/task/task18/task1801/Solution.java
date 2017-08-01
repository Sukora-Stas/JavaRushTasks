package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(s);

        int max = 0;
        int data;
        while (fileInputStream.available() > 0) {
            data = fileInputStream.read();
            if (max < data) {
                max = data;
            }
        }
        System.out.println(max);

        reader.close();
        fileInputStream.close();

    }
}
