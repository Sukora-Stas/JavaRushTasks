package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        int spaceCount = 0;
        double result;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            count++;
            if (data == 32) {
                spaceCount++;
            }
        }
//        System.out.println(count);
//        System.out.println(spaceCount);
//        double result = ((double) countSpace / (double) countSymbol) * 100;
//        System.out.println(String.format("%.2f",result));

        result = (double) spaceCount/count * 100;
        System.out.printf("%.2f",result);

        fileInputStream.close();
    }
}
