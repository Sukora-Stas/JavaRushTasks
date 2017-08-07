package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileOutputStream file_out = new FileOutputStream(file1);

        FileInputStream file_1 = new FileInputStream(file1);

        FileInputStream file_2 = new FileInputStream(file2);

        while (file_2.available() > 0) {
            file_out.write(file_2.read());
        }

        while (file_1.available() > 0) {
            file_out.write(file_1.read());
        }

        reader.close();
        file_1.close();
        file_2.close();
        file_out.close();

    }
}
