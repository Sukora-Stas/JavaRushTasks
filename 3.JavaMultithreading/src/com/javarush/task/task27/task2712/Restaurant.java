package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Sukora Stas.
 */
//public class Restaurant {
//
//    private static final int ORDER_CREATING_INTERVAL = 100;
//    public static void main(String[] args) {
//        try {
//            List<Tablet> tablets = new ArrayList<>();
//
//            Cook cook = new Cook("Amigo");
//            Cook cook2 = new Cook("Cook");
//
//            StatisticManager.getInstance().register(cook);
//            StatisticManager.getInstance().register(cook2);
//
//            OrderManager orderManager = new OrderManager();
//
//            for (int i = 1; i < 6; i++) {
//                Tablet tablet = new Tablet(i);
//                tablet.addObserver(orderManager);
//                tablets.add(tablet);
//            }
//            Waiter waiter = new Waiter();
//            cook.addObserver(waiter);
//            cook2.addObserver(waiter);
//
//            RandomOrderGeneratorTask tasks = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
//            Thread thread = new Thread(tasks);
//            thread.start();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignore) {
//            }
//            thread.interrupt();
//            DirectorTablet directorTablet = new DirectorTablet();
//            directorTablet.printAdvertisementProfit();
//            directorTablet.printCookWorkloading();
//            directorTablet.printActiveVideoSet();
//            directorTablet.printArchivedVideoSet();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Amigo2");
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);
        }


        Thread randomOrderGeneratorTaskThread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        Thread thread = new Thread(randomOrderGeneratorTaskThread);
        Thread cookThread1 = new Thread(cook1);
        Thread cookThread2 = new Thread(cook2);
        thread.start();
        cookThread1.start();
        cookThread2.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {

        }
        thread.interrupt();
        cookThread1.interrupt();
        cookThread2.interrupt();
        randomOrderGeneratorTaskThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}

