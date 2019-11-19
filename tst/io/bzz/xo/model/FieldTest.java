package io.bzz.xo.model;

import io.bzz.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() throws Exception{
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXLessThenZero() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        try {
            field.getFigure(inputPoint);
            fail();
              } catch (InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenYLessThenZero() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenXMoreThenSize() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(5,0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenYMoreThenSize() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,5);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}

    }
}