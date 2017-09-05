package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
//        ConsoleHelper.writeMessage(this.toString());
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish : dishes) {
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";
        else return "Your order: "
                + dishes.toString()
                + " of " + tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
