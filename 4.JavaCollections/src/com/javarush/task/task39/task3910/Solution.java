package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println("0:" + isPowerOfThree(0));
        System.out.println("1:" + isPowerOfThree(1));
        System.out.println("2:" + isPowerOfThree(2));
        System.out.println("3:" + isPowerOfThree(3));
        System.out.println("9:" + isPowerOfThree(9));
        System.out.println("10:" + isPowerOfThree(10));
        System.out.println("27:" + isPowerOfThree(27));
        System.out.println("81:" + isPowerOfThree(81));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0) return
                false;

        while ((n % 3) == 0) {
            n = n / 3;
        }

        if (n == 1)
            return true;


        return false;
    }
}
