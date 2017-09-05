package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

/**
 * Created by Sukora Stas.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {

        if (values().length == 0) {
            return "";
        }
        return Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }

    //getters
    public int getDuration() {
        return duration;
    }

}
