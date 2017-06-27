package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        int a=Integer.parseInt(reader.readLine());

        if(a<18){
            System.out.println("Подрасти еще");
        }
    }
}
