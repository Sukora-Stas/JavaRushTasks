package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileReader fileReader = new FileReader("unknown.file.txt");
    }

    public static void main(String[] args) {

    }
}
