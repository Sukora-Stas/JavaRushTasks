package com.javarush.task.task36.task3607;


import java.util.concurrent.DelayQueue;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return DelayQueue.class; //hack
    }
}
