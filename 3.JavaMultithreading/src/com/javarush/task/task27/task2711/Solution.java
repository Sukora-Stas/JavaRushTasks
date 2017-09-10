package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/
public abstract class Solution {

    private final CountDownLatch latch = new CountDownLatch(1);


    public void someMethod() throws InterruptedException {

        latch.await();
        retrieveValue();
        latch.countDown();

    }

    abstract void retrieveValue();
}