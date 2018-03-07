package com.javarush.task.task36.task3609;

/* 
Рефакторинг MVC
*/

public class Solution {
    public static void main(String[] args) {
        //Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();

        //Create a view : to show car's speed on speedometer(console)
        SpeedometerView view = new SpeedometerView();

        CarController controller = new CarController(model, view);
        controller.updateView();

        //Update model data
        controller.speedUp(15);
        controller.updateView();

        //Update model data
        controller.speedUp(50);
        controller.updateView();

        //Update model data
        controller.speedDown(7);
        controller.updateView();
    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera classic");
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);
        return currentCar;
    }
}