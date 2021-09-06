package fi.utu.tech.exercise2.task3;

public class TicTacToe {
    public static void drawBoard(Boolean[][] board) {
        for (var row : board) {
            for (var c : row)
                System.out.print(c);
            System.out.println();
        }
    }
}
