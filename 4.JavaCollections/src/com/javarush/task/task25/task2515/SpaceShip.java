package com.javarush.task.task25.task2515;

/**
 * Created by Sukora Stas.
 */
public class SpaceShip extends BaseObject {


    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    //вектор движения (-1 влево,+1 вправо)
    private double dx = 0;

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    /**
     * Метод рисует свой объект на "канвасе".
     */
    @Override
    public void draw(Canvas canvas) {

    }

    /**
     * Двигаем себя на один ход.
     * Проверяем столкновение с границами.
     */
    @Override
    public void move() {
        x += dx;

        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }

    /**
     * Стреляем.
     * Создаем две ракеты: слева и справа от корабля.
     */
    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }

}
