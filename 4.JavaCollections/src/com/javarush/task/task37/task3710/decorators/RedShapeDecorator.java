package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Created by Sukora Stas.
 */
public class RedShapeDecorator extends ShapeDecorator{
    private Shape shape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.shape = decoratedShape;
    }

    private void setBorderColor (Shape shapeDecorator) {
        System.out.println(String.format("Setting border color for %s to red.", shapeDecorator.getClass().getSimpleName()));

    }

    @Override
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}
