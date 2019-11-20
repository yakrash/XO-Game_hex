package io.bzz.xo.controllers;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinController {

    public Figure getWinner(Field field) {

        try {
            if (checkHoris(field) != null) return checkHoris(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        try {
            if (checkVert(field) != null) return checkVert(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        try {
            if (checkDiag1(field) != null) return checkDiag1(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        try {
            if (checkDiag2(field) != null) return checkDiag2(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Figure checkHoris(Field field) throws InvalidPointException {
        for (int x = 0; x < field.getSize(); x++) {
            int countX = 0;
            int countO = 0;
            for (int y = 0; y < field.getSize(); y++) {
                Point point = new Point(x, y);
                if (field.getFigure(point) == Figure.X) countX++;
                if (field.getFigure(point) == Figure.O) countO++;
                if (y == field.getSize() - 1 && countX == field.getSize()) return Figure.X;
                if (y == field.getSize() - 1 && countO == field.getSize()) return Figure.O;
            }
        }
        return null;
    }

    private Figure checkVert(Field field) throws InvalidPointException {
        for (int x = 0; x < field.getSize(); x++) {
            int countX = 0;
            int countO = 0;
            for (int y = 0; y < field.getSize(); y++) {
                Point point = new Point(y, x);
                if (field.getFigure(point) == Figure.X) countX++;
                if (field.getFigure(point) == Figure.O) countO++;
                if (y == field.getSize() - 1 && countX == field.getSize()) return Figure.X;
                if (y == field.getSize() - 1 && countO == field.getSize()) return Figure.O;
            }
        }
        return null;
    }

    private Figure checkDiag1(Field field) throws InvalidPointException {
        int countX = 0;
        int countO = 0;
        for (int x = 0, y = field.getSize()-1; x < field.getSize(); x++, y--) {
            Point point = new Point(x, y);
            if (field.getFigure(point) == Figure.X) countX++;
            if (field.getFigure(point) == Figure.O) countO++;
            if (countX == field.getSize()) return Figure.X;
            if (countO == field.getSize()) return Figure.O;
        }
        return null;
    }

    private Figure checkDiag2(Field field) throws InvalidPointException {
        int countX = 0;
        int countO = 0;
        for (int x = 0; x < field.getSize(); x++) {
            Point point = new Point(x, x);
            if (field.getFigure(point) == Figure.X) countX++;
            if (field.getFigure(point) == Figure.O) countO++;
            if (x == field.getSize() - 1 && countX == field.getSize()) return Figure.X;
            if (x == field.getSize() - 1 && countO == field.getSize()) return Figure.O;
        }
        return null;
    }
}
