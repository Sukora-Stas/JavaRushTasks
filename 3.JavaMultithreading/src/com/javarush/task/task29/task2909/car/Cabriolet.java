package com.javarush.task.task29.task2909.car;

/**
 * Created by Sukora Stas.
 */
public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }


    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}
