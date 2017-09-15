package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

/**
 * Created by Sukora Stas.
 */
public class Controller implements EventListener {
    private View view;
    private Model model;

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    public Controller() {
        view=new View(this);
        model=new Model();
        view.init();
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}
