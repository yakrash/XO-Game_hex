package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winController.getWinner(field));
        }
    }
    @Test
    public void testGetWinnerWhenNoWinnerRow() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
            field.setFigure(new Point(2, 0), Figure.X);
            field.setFigure(new Point(2, 1), Figure.O);
            field.setFigure(new Point(2, 2), Figure.X);
            assertNull(winController.getWinner(field));
    }
    @Test
    public void testGetWinnerWhenWinnerCol() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winController.getWinner(field));
        }
    }
    @Test
    public void testGetWinnerWhenNoWinnerCol() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);
            assertNull(winController.getWinner(field));
    }
    @Test
    public void testGetWinnerWhenWinnerDiag1() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
            field.setFigure(new Point(0, 2), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 0), Figure.X);
            assertEquals(Figure.X, winController.getWinner(field));
   }


    @Test
    public void testGetWinnerWhenNoWinnerDiag1() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winController.getWinner(field));


    }

    @Test
    public void testGetWinnerWhenWinnerDiag2() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, winController.getWinner(field));
    }
    @Test
    public void testGetWinnerWhenNoWinnerDiag2() throws InvalidPointException {
        final Field field = new Field();
        final WinController winController = new WinController();
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winController.getWinner(field));
    }

}