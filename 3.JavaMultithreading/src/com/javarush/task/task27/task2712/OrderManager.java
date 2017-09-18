package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Sukora Stas.
 */
public class OrderManager implements Observer {

    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread threadDaemon = new Thread() {
            Set<Cook> cooks = StatisticManager.getInstance().getCooks();
            @Override
            public void run() {
                while (true) {
                    try {
                        for (final Cook cook : cooks) {
                            if (!cook.isBusy() && !orderQueue.isEmpty()) {
                                final Order order = orderQueue.poll();
                                Thread th = new Thread() {
                                    @Override
                                    public void run() {
                                        cook.startCookingOrder(order);
                                    }
                                };
                                th.start();
                            }
                        }
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        //break;
                    }
                }
            }
        };
        threadDaemon.setDaemon(true);
        threadDaemon.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        }
        catch (InterruptedException e) {}
    }
}
