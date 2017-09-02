package com.javarush.task.task26.task2607;

import java.util.concurrent.atomic.AtomicInteger;

/*
Вежливость - это искусственно созданное хорошее настроение
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static class IntegerHolder {

        private final AtomicInteger value = new AtomicInteger();

        public synchronized int get() {
            return value.get();
        }
        public synchronized void set(int i) {
            value.set(i);
        }

    }
}
