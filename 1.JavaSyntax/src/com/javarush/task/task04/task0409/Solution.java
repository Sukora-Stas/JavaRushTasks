package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        //::CODE:
//        int c = 10;
//        int m, n;
//
//        if (a > c) {
//            m = a % c;
//        } else {
//            m = abs(a - c);
//        }
//
//        if (b > c) {
//            n = b % c;
//        } else {
//            n = abs(b - c);
//        }
////        System.out.println(m + " " + n);
//
//        if(m<n){
////            System.out.println("ближайшее к десяти "+a);
//            System.out.println(a);
//        }
//        else{
////            System.out.println("ближайшее к десяти "+b);
//            System.out.println(b);
//        }


        System.out.println(abs(10 - a) > abs(10 - b) ? b : a);

    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}