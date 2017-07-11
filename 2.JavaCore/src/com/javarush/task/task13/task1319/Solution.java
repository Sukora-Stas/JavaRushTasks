package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String s = reader.readLine();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s));
            String str;
            while (true) {
                str = reader.readLine();
                if (str.equals("exit")) {
                    bufferedWriter.write(str);
                    break;
                }

                bufferedWriter.write(str + '\n');

                bufferedWriter.flush();

            }
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
