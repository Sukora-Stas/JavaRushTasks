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
private boolean isGameOver;

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

    /**
     * Проверяем столкновение с кирпичами.
     * Если столкновение было - шарик отлетает в случайном направлении 0..360 градусов
     */
    public void checkBricksBump()
    {
        for (Brick currentBrick : bricks) {
            if (ball.isIntersec(currentBrick)) {
                double angel = Math.random() * 360;
                ball.setDirection(angel);
                bricks.remove(currentBrick);
                break;
            }
        }
    }

    /**
     * Проверяем столкновение с подставкой.
     * Если столкновение было - шарик отлетает в случайном направлении  вверх 80..100 градусов.
     */
    public void checkStandBump()
    {
        if (ball.isIntersec(stand)) {
            double angel = 80 + Math.random()*20;
            ball.setDirection(angel);
        }
    }

    /**
     * Проверяем - не улетел ли шарик через дно.
     * Если да - игра окончена (isGameOver = true)
     */
    public void checkEndGame()
    {
        if (ball.getY() >= height)
            isGameOver = true;
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
