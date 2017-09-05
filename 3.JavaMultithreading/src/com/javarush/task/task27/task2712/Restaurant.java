package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

/**
 * Created by Sukora Stas.
 */
public class Restaurant {
    public static void main(String[] args) throws Exception {
        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(5);


        tablet.addObserver(cook);
        tablet.createOrder();


    }
}
