package com.javarush.task.task15.task1530;

/**
 * Created by Sukora Stas.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();

    public abstract void putIngredient();

    public abstract void pour();

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
