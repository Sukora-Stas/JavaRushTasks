package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sukora Stas.
 */
public class Cook extends Observable implements Observer {

    private final String name;


    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    //    @Override
//    public void update(Observable observable, Object o) {
//
//            Order order = (Order) o;
//            ConsoleHelper.writeMessage("Start cooking - " + order ); //+ ", cooking time " + order.getTotalCookingTime() + "min"
//            setChanged();
//            notifyObservers(order);
//
//    }
    @Override
    public void update(Observable observable, Object o)
    {
        if (o instanceof Order)
        {
            Order order = (Order) o;
            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
            setChanged();
            notifyObservers(order);
        }
    }
}
