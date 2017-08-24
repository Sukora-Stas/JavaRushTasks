package com.javarush.task.task24.task2413;

import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class Arkanoid {
    private int width;
    private int height;

    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;

    static Arkanoid game;

    public static void main(String[] args) {

    }

    public void run() {

    }

    public void move() {
        stand.move();
        ball.move();
    }

    public void draw(Canvas canvas)
    {
        drawBoders(canvas);
        for (Brick current : bricks)
            current.draw(canvas);
        ball.draw(canvas);
        stand.draw(canvas);
        //отрисуй границы
        //отрисуй кирпичи
        //отрисуй шарик
        //отрисуй подставку
    }

    /**
     * Рисуем на холсте границы
     */
    private void drawBoders(Canvas canvas)
    {
        //draw game
        for (int i = 0; i < width + 2; i++)
        {
            for (int j = 0; j < height + 2; j++)
            {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++)
        {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++)
        {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }


    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
