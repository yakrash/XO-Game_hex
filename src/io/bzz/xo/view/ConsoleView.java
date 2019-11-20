package io.bzz.xo.view;

import io.bzz.xo.controllers.CurrentMoveController;
import io.bzz.xo.controllers.MoveController;
import io.bzz.xo.controllers.WinController;
import io.bzz.xo.model.Field;
import io.bzz.xo.model.Figure;
import io.bzz.xo.model.Game;
import io.bzz.xo.model.exceptions.AlreadyOccupiedException;
import io.bzz.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {
    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinController winController = new WinController();
    private final MoveController moveController = new MoveController();

    public void show(Game game) {
        final Field field = game.getField();
        System.out.println("Game Name: " + game.getName());
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
            if (x != field.getSize() - 1)
                printSeparator();
        }

    }

    public boolean move(Game game) {
        final Field field = game.getField();
        final Figure currentMove = currentMoveController.currentMove(field);
        final Figure winner = winController.getWinner(field);
        if (currentMove == null) {
            if (winner == null) {
                System.out.println("Ooh you both won");
                return false;
            }
        }
        if (winner != null) {
            System.out.println("WINNER: " + winner);
            return false;
        } else {
            System.out.println("Now go: " + currentMove);
            try {
                moveController.applyFigure(field, askPoint(), currentMove);
            } catch (InvalidPointException | AlreadyOccupiedException e) {
                //e.printStackTrace();
                System.out.println("Invalid point--1--1-1");
            }
        }

        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinate) {
        System.out.println("Please input " + coordinate);
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
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
            System.out.print(" ");
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
            if (y != field.getSize() - 1) System.out.print("|");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~~");
    }
}
