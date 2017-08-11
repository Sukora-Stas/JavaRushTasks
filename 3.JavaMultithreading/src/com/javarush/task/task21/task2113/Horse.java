package com.javarush.task.task21.task2113;

/**
 * Created by Sukora Stas.
 */
public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        this.distance += (speed * Math.random());
    }

    public void print() {
        int size = (int) Math.floor(this.distance);
        for (int i = 0; i < size; i++) {
            System.out.print(".");
        }
        System.out.println(this.getName());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


}
