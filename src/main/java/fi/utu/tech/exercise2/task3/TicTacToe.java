package fi.utu.tech.exercise2.task3;

import java.util.Objects;

public class TicTacToe {

    /**
     * Prints a tic-tac-toe board.
     * true = 'x', false = 'o', null = '.'
     */
    public static void drawBoard(Boolean[][] board) {

        for (var row : board) {

            StringBuilder outputRow = new StringBuilder();

            for (var c : row) {

                if (Objects.isNull(c)) {
                    outputRow.append('.');
                } else if (c) {
                    outputRow.append('x');
                } else {
                    outputRow.append('o');
                }

            }

            System.out.println(outputRow.toString());

        }

    }

}
