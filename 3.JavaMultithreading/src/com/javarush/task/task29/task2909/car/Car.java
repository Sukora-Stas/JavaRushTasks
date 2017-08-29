package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {

        if (numberOfLiters < 0) {
            throw new Exception();
        }
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        double consumption;

        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        }
        else {
            consumption = getSummerConsumption(length);
        }

        return consumption;
    }


    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {

        return !(date.before(summerStart) || date.after(summerEnd));
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }


    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;

        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    private boolean canPassengersBeTransferred() {
        return (isDriverAvailable() && fuel > 0);
    }


    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {

        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();


    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case TRUCK:
                return new Truck(numberOfPassengers);
            default:
                return null;
        }

    }
}