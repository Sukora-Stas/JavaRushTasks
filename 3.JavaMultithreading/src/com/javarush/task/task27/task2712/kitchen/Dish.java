package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

/**
 * Created by Sukora Stas.
 */
public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {

        if (values().length == 0) {
            return "";
        }
        return Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}
