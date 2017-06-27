package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String m1 = reader.readLine();
        String m2 = reader.readLine();
        String m3 = reader.readLine();

        int n1 = Integer.parseInt(m1);
        int n2 = Integer.parseInt(m2);
        int n3 = Integer.parseInt(m3);


        if(n2==n3 && n1==n2){
            System.out.println(n1 +" "+n2+" "+n3);
        }else if (n1==n2){
            System.out.println(n1 +" "+n2);
        }else if(n2==n3){
            System.out.println(n2 +" "+n3);
        }else if(n1==n3){
            System.out.println(n1 +" "+n3);
        }
    }
}