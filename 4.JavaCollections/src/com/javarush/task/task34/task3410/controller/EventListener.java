package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;

/**
 * Created by Sukora Stas.
 */
public interface EventListener {

    void move(Direction direction);

    void restart();

    void startNextLevel();

    void levelCompleted(int level);

}
