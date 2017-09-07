package com.javarush.task.task22.task2213;

/**
 * Created by Sukora Stas.
 */
public class Field {

    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }
    }

    public void removeFullLines() {

    }

    public Integer getValue(int x, int y) {
        return null;
    }

    public void setValue(int x, int y, int value) {

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

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
