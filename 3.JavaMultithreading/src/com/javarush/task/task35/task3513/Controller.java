package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

/**
 * Created by Sukora Stas.
 */
public class Controller extends KeyAdapter {

    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
    public int getScore() {
        return model.score;
    }

}
