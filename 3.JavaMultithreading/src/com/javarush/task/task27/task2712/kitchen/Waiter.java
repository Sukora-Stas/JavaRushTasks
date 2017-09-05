package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sukora Stas.
 */
public class Waiter implements Observer {
    @Override
    public void update(Observable observable, Object o)
    {

            ConsoleHelper.writeMessage(o + " was cooked by " + observable);

    }
}
