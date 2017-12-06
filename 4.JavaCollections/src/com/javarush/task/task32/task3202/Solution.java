package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        try {
            while (is.available() > 0) {
                byte[] buf = new byte[1024];
                int len = is.read(buf);
                String s = new String(buf, 0, len);
                writer.append(s);
            }
        } catch (Exception e) {
            return new StringWriter();
        }

        return writer;
    }
}