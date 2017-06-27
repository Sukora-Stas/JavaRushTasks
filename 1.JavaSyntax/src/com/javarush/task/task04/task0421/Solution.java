package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        if(s1.equals(s2)){
            System.out.println("Имена идентичны");
        }else if(s1.length()==s2.length()){
            System.out.println("Длины имен равны");
        }
    }
}
