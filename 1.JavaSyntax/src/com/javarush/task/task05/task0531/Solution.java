package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int minimum = min(a, b,c,d,e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c,int d,int e) {
        int min = 0;
        if (a <= b && a <= c && a <= d && a <= e){
            min = a;
        }
        else if (b <= a && b <= c && b <= d && b <= e){
            min = b;
        }
        else if (c <= a && c <= b && c <= d && c <= e){
            min = c;
        }
        else if (d <= a && d <= b && d <= c && d <= e){
            min = d;
        }
        else {
            min = e;
        }
        return min;


    }
}
