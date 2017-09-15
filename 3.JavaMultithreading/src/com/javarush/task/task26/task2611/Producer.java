package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sukora Stas.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap();

    public Producer(ConcurrentHashMap concurrentHashMap) {
        this.map = concurrentHashMap;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        while (!currentThread.isInterrupted()) {
            try {
                i++;
                map.put(new Integer(i).toString(), new String("Some text for " + i));
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(currentThread.getName() + " thread was terminated");
            }
        }
    }
}