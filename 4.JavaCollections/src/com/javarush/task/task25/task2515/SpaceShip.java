package com.javarush.task.task25.task2515;

/**
 * Created by Sukora Stas.
 */
public class SpaceShip extends BaseObject {


    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    //вектор движения (-1 влево,+1 вправо)
    private double dx = 0;

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

}
