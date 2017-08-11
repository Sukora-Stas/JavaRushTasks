package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/
public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");//5
        }

        public void method2() {
            System.out.println("A class, method2");//3
            method1();//4
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();//2
            System.out.println("B class, method1");//6

        }

        public void method2() { //не используется
            System.out.println("B class, method2");
        }
    }

    private static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");//0
            super.method1();//1

        }
    }
}
