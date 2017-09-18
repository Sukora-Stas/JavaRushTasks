package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sukora Stas.
 */
public class Tablet extends Observable {
    public final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Order createOrder()
    {
        Order order=null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                queue.put(order);
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
                advertisementManager.processVideos();
            }
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (InterruptedException e)
        {

        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            ConsoleHelper.writeMessage(testOrder.toString());
            if (!testOrder.isEmpty()) {
                AdvertisementManager advertisementManager = new AdvertisementManager(testOrder.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        }
    }
}

