package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.AlreadyOccupiedException;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException, AlreadyOccupiedException {


        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }

}
