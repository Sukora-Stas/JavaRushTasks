package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sukora Stas.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        int coolingTime = ((Order) arg).getTotalCookingTime();
        ConsoleHelper.writeMessage("Start cooking - " + arg.toString() + ", cooking time " + coolingTime + "min");
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Order) arg).getTablet().toString(),
                this.name, ((Order) arg).getTotalCookingTime() ,((Order) arg).getDishes()));
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public String toString() {
        return name;
    }
}
