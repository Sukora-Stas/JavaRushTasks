package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        // Lower case the String and remove white spaces
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");

        // Assume 8-bit ascii encoding
        boolean[] isOdd = new boolean[256];

        // For each character c in the input String, save whether it is
        // represented an odd number of times
        for (int i = 0; i < s.length(); i++) {
            isOdd[s.charAt(i)] = !isOdd[s.charAt(i)];
        }

        // Count the number of odd characters
        int numberOdds = 0;

        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                numberOdds++;
            }
            // At most one character can have an odd count
            if (numberOdds > 1) {
                return false;
            }
        }
        return true;
    }
}
