package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();

            InputStream inputStream = new FileInputStream(fileName);


            while (inputStream.available() > 0) {
                System.out.print((char) inputStream.read());

            }
            reader.close();
            inputStream.close();

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}