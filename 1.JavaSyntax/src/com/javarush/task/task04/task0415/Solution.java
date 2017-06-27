package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static int sum(int a, int b){
        return a+b;
    }


    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sa = reader.readLine();
        String sb = reader.readLine();
        String sc= reader.readLine();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int c = Integer.parseInt(sc);

                if((sum(a,b)>c)&&(sum(b,c)>a)&&(sum(a,c)>b)){
                    System.out.println("Треугольник существует.");
                } else{
                    System.out.println("Треугольник не существует.");
                }
    }
}