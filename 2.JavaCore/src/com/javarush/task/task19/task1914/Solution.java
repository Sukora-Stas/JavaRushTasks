package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String[] values = outputStream.toString().split(" ");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        int result = 0;
        switch (values[1]) {
            case "+": {
                result = a + b;
                break;
            }
            case "-": {
                result = a - b;
                break;
            }
            case "*": {
                result = a * b;
                break;
            }
        }
        System.out.println(outputStream.toString().replaceAll("\\p{Cntrl}","") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

