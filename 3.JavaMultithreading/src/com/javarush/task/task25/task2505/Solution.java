package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.currentThread();
                    sleep(500);
                    System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage()));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

