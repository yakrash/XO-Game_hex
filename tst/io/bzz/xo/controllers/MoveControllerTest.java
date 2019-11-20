package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.AlreadyOccupiedException;
import io.bzz.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void testApplyFigureWhenException() throws AlreadyOccupiedException,
                                                    InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final MoveController moveController = new MoveController();
        field.setFigure(inputPoint, Figure.O);
        try {
            moveController.applyFigure(field, inputPoint, Figure.X);
            fail();
        } catch (AlreadyOccupiedException e) {}

    }

    @Test
    public void testApplyFigure() throws AlreadyOccupiedException,
            InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final MoveController moveController = new MoveController();
        moveController.applyFigure(field, inputPoint, Figure.X);
        assertEquals(Figure.X, field.getFigure(inputPoint));


    }
}