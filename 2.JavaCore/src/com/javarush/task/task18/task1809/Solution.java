package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String in1 = reader.readLine();
        String in2 = reader.readLine();

        FileInputStream in = new FileInputStream(in1);
        FileOutputStream out = new FileOutputStream(in2);

        Stack<Integer> stack = new Stack<>();

        while (in.available() > 0) {
            int data = in.read();
            stack.push(data);//добавляю в стек
        }

        while (!stack.isEmpty()) {
            out.write(stack.pop());
        }

        in.close();
        out.close();
        reader.close();

    }
}
