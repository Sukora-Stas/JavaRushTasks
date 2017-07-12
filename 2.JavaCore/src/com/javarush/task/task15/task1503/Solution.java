package com.javarush.task.task15.task1503;

/* 
ООП - машинки
*/


public class Solution {
    public static void main(String[] args) {
        new Solution.LuxuriousCar().printlnDesire();
        new Solution.CheapCar().printlnDesire();
        new Solution.Ferrari().printlnDesire();
        new Solution.Lanos().printlnDesire();
    }

    public static class Ferrari extends LuxuriousCar {
        public static void printlnDesire() {
            //add your code here
            System.out.println(WANT_STRING + FERRARI_NAME);
        }
    }

    public static class Lanos extends CheapCar {
        public static void printlnDesire() {
            //add your code here
            System.out.println(WANT_STRING + LANOS_NAME);
        }
    }

    public static class LuxuriousCar extends Constants {
        static void printlnDesire() {
            System.out.println(WANT_STRING + LUXURIOUS_CAR);
        }
    }

    public static class CheapCar extends Constants {
        static void printlnDesire() {
            System.out.println(WANT_STRING + CHEAP_CAR);
        }
    }

    public static abstract class Constants {
        public static String WANT_STRING = "Я хочу ездить на ";
        public static String LUXURIOUS_CAR = "роскошной машине";
        public static String CHEAP_CAR = "дешевой машине";
        public static String FERRARI_NAME = "Феррари";
        public static String LANOS_NAME = "Ланосе";

    }
}
