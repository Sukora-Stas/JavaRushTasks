package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = conReader.readLine();
        String fileName2 = conReader.readLine();
        conReader.close();


        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        int i=1;
        while (fileReader.ready()) {
            int value = fileReader.read();
            if (i % 2 == 0)
                fileWriter.write(value);
            i++;
        }
        fileReader.close();
        fileWriter.close();

    }
}
