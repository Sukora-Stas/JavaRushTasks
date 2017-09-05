package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sukora Stas.
 */
public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Cook");
        StatisticManager.getInstance().register(cook);
        StatisticManager.getInstance().register(cook2);
        OrderManager orderManager = new OrderManager();
        for (int i = 1; i < 6; i++) {
            Tablet tablet = new Tablet(i);
            tablet.addObserver(orderManager);
            tablets.add(tablet);
        }
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);
        RandomOrderGeneratorTask tasks = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(tasks);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
