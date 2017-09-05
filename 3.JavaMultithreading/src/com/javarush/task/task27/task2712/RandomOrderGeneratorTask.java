package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;
    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.interval = interval;
        this.tablets = tablets;
    }
    @Override
    public void run() {
        if (tablets.size() > 0) {
            while (!Thread.currentThread().isInterrupted()) {
                int rnd = (int) (Math.random()*tablets.size());
                Tablet tablet = tablets.get(rnd);
                tablet.createTestOrder();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
