package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveControllerWhenDraw() throws InvalidPointException {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            }
        assertNull(currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveControllerWhenGoX() throws InvalidPointException {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 2), Figure.X);
            field.setFigure(new Point(1, 2), Figure.O);

        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    public void testCurrentMoveControllerWhenGoO() throws InvalidPointException {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);

        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

}
