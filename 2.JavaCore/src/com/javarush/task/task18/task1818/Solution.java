package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream file_2 = new FileInputStream(file2);

        FileInputStream file_3 = new FileInputStream(file3);

        FileOutputStream file_1 = new FileOutputStream(file1);

        while (file_2.available() > 0) {
            file_1.write(file_2.read());
        }
        while (file_3.available() > 0) {
            file_1.write(file_3.read());
        }
        reader.close();
        file_1.close();
        file_2.close();
        file_3.close();
    }
}
