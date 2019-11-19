package io.bzz.xo.model;

import io.bzz.xo.model.exceptions.AlreadyOccupiedException;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private final static int FIELD_SIZE = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;
    private final Figure [][] field = new Figure [FIELD_SIZE][FIELD_SIZE];


    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure (final Point point)
            throws InvalidPointException {

        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure (final Point point, final Figure figure)
            throws InvalidPointException, AlreadyOccupiedException {

        if (!checkPoint(point)){
            throw new InvalidPointException();
        }

        if (getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field[point.x][point.y] = figure;
    }

    public boolean checkPoint(final Point point){
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    public boolean checkCoordinate (int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
