package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

/**
 * Created by Sukora Stas.
 */
public class Model {
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
