package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long position = Integer.parseInt(args[1]);

        String text = args[2];

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        position = position > file.length() ? file.length() : position;
        file.seek(position);
        file.write(text.getBytes());
        file.close();


    }
}
