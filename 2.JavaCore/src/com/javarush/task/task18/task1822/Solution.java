package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1. Считать с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile;
        nameFile = reader.readLine();
        // 2. Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
        String str = "";
        while (in.ready()) {
            str = in.readLine();                        //читаем строку
            String[] arrStr = str.split(" ");    //разбиваем эту строку по пробелам " "
            if (arrStr[0].equals(args[0])) {           //если id совпал, то выводим строку str
                System.out.println(str);
                break;// ТУТ ОШИБКА
            }
        }
        // 3. Закрыть потоки.
        in.close();
        reader.close();
    }
}

