package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove (Field field)  {
        int count = 0;
        for (int x = 0; x < field.getSize(); x++){
            for (int y = 0; y < field.getSize(); y++) {
                Point point = new Point (x, y);
                try {
                    if (field.getFigure(point) != null) count++;
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count == field.getSize()*field.getSize())
            return null;
        if (count % 2 == 0)
        return Figure.X;
        else return Figure.O;
    }

}
