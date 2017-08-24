package com.javarush.task.task24.task2413;

/**
 * Created by Sukora Stas.
 */
public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        double dx = speed * direction;
        x = x + dx;
    }

    /**
     * direction устанавливается равным -1
     */
    public void moveLeft() {
        direction = -1;
    }

    /**
     * direction устанавливается равным +1
     */
    public void moveRight() {
        direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }


}
