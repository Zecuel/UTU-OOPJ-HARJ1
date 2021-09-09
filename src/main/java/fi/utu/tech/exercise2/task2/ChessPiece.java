package fi.utu.tech.exercise2.task2;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum ChessPiece {

    King('K'), Queen('Q'), Rook('R'),
    Bishop('B'), Knight('N'), Pawn('P');

    ChessPiece(Character c) {
        this.symbol = c;
    }

    public final Character symbol;

    public static void printBoard(List<List<String>> board) {

        StringBuilder result = new StringBuilder();

        for (List<String> row : board) {

            result.append("|");

            for (String chessPiece : row) {
                result.append(chessPiece);
            }

            result.append("|\n");

        }

        System.out.println(result.toString());

    }

    public static List<List<String>> createEmptyBoard() {

        List<List<String>> board = new ArrayList<>();

        board.add(createBoardRow(null));

        board.add(createDefaultRoyalsBoardRow());

        board.add(createDefaultPawnBoardRow());

        board.add(createBoardRow(null));
        board.add(createBoardRow(null));
        board.add(createBoardRow(null));
        board.add(createBoardRow(null));

        board.add(createDefaultPawnBoardRow());

        board.add(createDefaultRoyalsBoardRow());

        board.add(createBoardRow(null));

        return board;
    }

    private static List<String> createDefaultRoyalsBoardRow() {

        return createBoardRow(
                Arrays.asList(
                        Rook.symbol.toString(),
                        Knight.symbol.toString(),
                        Bishop.symbol.toString(),
                        Queen.symbol.toString(),
                        King.symbol.toString(),
                        Bishop.symbol.toString(),
                        Knight.symbol.toString(),
                        Rook.symbol.toString()
                )
        );

    }

    private static List<String> createDefaultPawnBoardRow() {

        return createBoardRow(
                Arrays.asList(
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString(),
                        Pawn.symbol.toString()
                )
        );

    }

    /**
     * Luo shakkilaudalle vaakarivin annettujen shakkinappuloiden perusteella
     *     tai tyhjän rivin (- merkkejä) jos chessPieces on tyhjä
     *
     * Syötteeksi hyväksytään joko null -arvo tai lista, jonka pituus on 8
     *
     * @.pre (chessPieces != null && chessPieces.length == 8) ||
     *       chessPieces == null
     *
     * @.post RESULT == FORALL(
     *            i : 0 <= i < chessPieces.length;
     *            RESULT[i] == chessPieces[i]
     *        ) ||
     *        RESULT == FORALL(
     *            i : 0 <= i < 8;
     *            RESULT[i] == "-"
     *        )
     *
     */
    private static List<String> createBoardRow(List<String> chessPieces) {

        if (!Objects.isNull(chessPieces)) {

            if (chessPieces.size() != 8) {
                throw new InvalidParameterException("Expected 8 chess pieces");
            }

        } else {

            chessPieces = Arrays.asList("-", "-", "-", "-", "-", "-", "-", "-");

        }

        return new ArrayList<>(chessPieces);
    }

}