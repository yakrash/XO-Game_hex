package io.bzz.xo.view;

import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.Game;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {

    public void show(Game game) {
        final Field field = game.getField();
        System.out.println("Game Name: " + game.getName());
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
            if (x != field.getSize() - 1)
                printSeparator();
        }

    }

    public void move(Game game) {


    }

    private void printLine(final Field field, final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : "   ");
            if (y != field.getSize() - 1) System.out.print("|");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~~");
    }
}
