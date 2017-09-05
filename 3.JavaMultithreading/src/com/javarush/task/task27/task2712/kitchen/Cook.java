package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sukora Stas.
 */
public class Cook extends Observable {

    private String name;
    private boolean busy;

    public boolean isBusy() {return busy;}

    public Cook(String name) {this.name = name;}

    @Override
    public String toString() {return name;}

    public void startCookingOrder(Order order) {
        this.busy = true;
        int orderTime = order.getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + orderTime + "min");
        CookedOrderEventDataRow eventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(), name, orderTime * 60, order.getDishes());
        StatisticManager.getInstance().register(eventDataRow);
        setChanged();
        notifyObservers(order);
        try {
            Thread.sleep(orderTime * 10);
        } catch (InterruptedException e) {
        }
        this.busy = false;
    }
}
