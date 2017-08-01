package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream f1 = new FileInputStream(file1);
        FileOutputStream f2 = new FileOutputStream(file2);
        FileOutputStream f3 = new FileOutputStream(file3);

        byte[] buffer = new byte[f1.available()];

        if (f1.available() % 2 == 0) {
            while (f1.available() > 0) {
                int count = f1.read(buffer);
                f2.write(buffer, 0, count / 2);
                f3.write(buffer, count / 2, count / 2);
            }
        } else {
            while (f1.available() > 0) {
                int count = f1.read(buffer);
                f2.write(buffer, 0, count / 2 + 1);
                f3.write(buffer, count / 2 + 1, count / 2);
            }
        }
        f1.close();
        f2.close();
        f3.close();


    }
}
