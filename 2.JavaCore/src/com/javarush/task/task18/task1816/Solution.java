package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int lettersСount = 0;
        while (file.available() > 0) {
            int bytE = file.read();
            if (bytE >= 65 && bytE <= 90 || bytE >= 97 && bytE <= 122)
                lettersСount++;
        }
        file.close();
        System.out.println(lettersСount);
    }
}
