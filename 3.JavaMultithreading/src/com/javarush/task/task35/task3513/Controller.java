package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Sukora Stas.
 */
public class Controller extends KeyAdapter {

    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame() {
        model.score =0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEvent key = e;
        if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameLost && !view.isGameWon) {
            if (key.getKeyCode() == KeyEvent.VK_LEFT) {
                model.left();
            }
            if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
                model.right();
            }
            if (key.getKeyCode() == KeyEvent.VK_UP) {
                model.up();
            }
            if (key.getKeyCode() == KeyEvent.VK_DOWN) {
                model.down();
            }
            if (key.getKeyCode() == KeyEvent.VK_Z) {
                model.rollback();
            }
        }
        if (model.maxTile == WINNING_TILE){
            view.isGameWon = true;
        }
        view.repaint();
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
    public int getScore() {
        return model.score;
    }

    public View getView() {
        return view;
    }
}
