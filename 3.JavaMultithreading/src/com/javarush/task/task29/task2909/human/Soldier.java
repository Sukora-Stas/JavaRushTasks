package com.javarush.task.task29.task2909.human;

/**
 * Created by Sukora Stas.
 */
public class Soldier extends Human{
    public Soldier(String name, int age) {

        super(name, age);
    }

    public void live() {
        fight();
    }
    public void fight() {
    }
}
