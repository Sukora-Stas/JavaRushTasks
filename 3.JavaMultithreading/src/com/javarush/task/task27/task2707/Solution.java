package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;
        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception
    {
        new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();

        Thread thread2=new Thread() {
            @Override
            public void run() {
                synchronized (o1)
                {
                    synchronized (o2)
                    {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
                    }
                }
            }
        };
        thread2.start();
        return Thread.State.BLOCKED.equals(thread2.getState());
    }

    public static Thread.State waitAndGetState(Thread thread) throws InterruptedException {
        Thread.sleep(300);
        return thread.getState();
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
