package fi.utu.tech.exercise2;

import fi.utu.tech.exercise2.task1.Utilities;
import fi.utu.tech.exercise2.task3.Age;
import fi.utu.tech.exercise2.task4.Foobar;

import fi.utu.tech.exercise2.task2.ChessBoard;

public class Main {
    /**
     * Main class.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        ChessBoard.printBoard(ChessBoard.createEmptyBoard(), true);

        for (var i : Foobar.foobar(new int[]{5, -6, 6, 6, 2, 3, 3, 3, 1})) {
            System.out.println(i);
        }

        Age.printAge(1, 1, 2021);

        System.out.println(Utilities.rot13("Niin hyvää puuta"));
        System.out.println(Utilities.toOct(12345));
    }
}
