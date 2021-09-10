package fi.utu.tech.exercise2.task2;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static fi.utu.tech.exercise2.task2.ChessPiece.*;

public class ChessBoard {

    /**
     * Kuvaa tyhjää ruutua laudalla
     *
     * Voitaisiin lisätä ChessPieces Enumiin, mutta
     *     alkuperäisyyden säilyttämistä varten siirretty
     *     tämän luokan sisälle vakioksi
     */
    public static final String EmptyChessPiece = "-";

    /**
     * Tulostaa shakkilaudan annettun 2-ulotteisen vektorilistan perusteella
     *
     * Laudan rivien määrä tulee olla 8. usePaddingRows lisää lautaan tyhjät
     *     nappularivit laudan alkuun ja loppuun, kuten tehtävän kuvauksessa
     *     esitetyssä laudassa on. Oletuksena tyhjiä rivejä ei lisätä
     *
     * !! Varsinainen toteutus eristetty getBoardString() metodiin määrittelyn helpottamiseksi !!
     *
     * @.pre usePaddingRows != null &&
     *       board != null &&
     *       board.length == 8 &&
     *       FORALL(
     *           i : 0 <= i < board.length;
     *           FORALL(
     *               j : 0 <= j < board[i].length;
     *               board[i][j].length == 8 &&
     *               List.of("-", "K", "Q", "R", "B", "N", "P").contains(board[i][j])   -- shakkinappulan tulee olla
     *                                                                                         joku näistä merkeistä
     *           )
     *       )
     *
     * @.post (metodi tulostaa annetun laudan)
     *
     */
    public static void printBoard(List<List<String>> board, boolean usePaddingRows) {
        System.out.println(getBoardString(board, usePaddingRows));
    }

    /**
     * Palauttaa shakkilaudan merkkijonona annettun 2-ulotteisen vektorilistan perusteella
     *
     * Laudan rivien määrä tulee olla 8. usePaddingRows lisää lautaan tyhjät
     *     nappularivit laudan alkuun ja loppuun, kuten tehtävän kuvauksessa
     *     esitetyssä laudassa on
     *
     * @.pre usePaddingRows != null &&
     *       board != null &&
     *       board.length == 8 &&
     *       FORALL(
     *           i : 0 <= i < board.length;
     *           FORALL(
     *               j : 0 <= j < board[i].length;
     *               board[i][j].length == 8 &&
     *               List.of("-", "K", "Q", "R", "B", "N", "P").contains(board[i][j])      -- shakkinappulan tulee olla
     *                                                                                            joku näistä merkeistä
     *           )
     *       )
     *
     * @.post board.length == RESULT.split("\n").length &&
     *        FORALL (                                                              -- split() yms lauseet jokaisella
     *            i : 0 <= i < board.length;                                           totuuslauseella erikseen käytetyn
     *            FORALL (                                                             notaation takia
     *                j : 0 <= j < board[i].length;
     *                RESULT.split("\n")[i].replace("|", "")[j] == board[i][j] &&   -- Nappulat kopioitu oikein
     *                RESULT.split("\n")[i].replace("|", "").length == 8 &&         -- Rivissä 8 nappulaa
     *                List.of("-", "K", "Q", "R", "B", "N", "P")
     *                    .contains(RESULT.split("\n")[i].replace("|", "")[j]) &&   -- Jokainen nappula on oikea nappula
     *                RESULT.split("\n")[i][0] == "|" &&                            -- "|" merkki rivin alussa
     *                RESULT.split("\n")[i][RESULT.length -1] == "|"                -- "|" merkki rivin lopussa
     *            )
     *        )
     *
     */
    public static String getBoardString(List<List<String>> board, boolean usePaddingRows) {

        if (board.size() != 8) {
            throw new InvalidParameterException("Laudassa tulee olla 8 riviä nappuloita.");
        }

        if (usePaddingRows) {
            board.add(0, createEmptyBoardRow()); // Add empty row as first element
            board.add(createEmptyBoardRow());      // Add empty row as last element
        }


        StringBuilder result = new StringBuilder();

        for (List<String> row : board) {

            result.append("|");                    // Add "|" before each row

            for (String chessPiece : row) {
                result.append(chessPiece);         // Add chess piece to board
            }

            result.append("|\n");                  // Add "|" after each row

        }

        return result.toString();
    }

    /**
     * Luo shakkilaudalle vaakarivin annettujen shakkinappuloiden perusteella
     *     tai tyhjän rivin (- merkkejä) jos chessPieces -vektori on tyhjä
     *
     * Syötevektori joko null -arvo tai vektori merkkijonoja, jonka pituus on 8
     *
     * @.pre (chessPieces != null && chessPieces.length == 8) ||
     *       chessPieces == null
     *
     * @.post FORALL(                                         -- Annettu vektori ei ollut null
     *            i : 0 <= i < chessPieces.length;
     *            RESULT[i] == chessPieces[i] &&
     *            List.of("-", "K", "Q", "R", "B", "N", "P") -- Nappula on sallittu merkki
     *                .contains(RESULT[i]
     *        ) ||
     *        FORALL(                                         -- Annettu vektori oli null
     *            i : 0 <= i < 8;
     *            RESULT[i] == "-"
     *        )
     *
     */
    public static List<String> createBoardRow(List<String> chessPieces) throws InvalidParameterException {

        if (!Objects.isNull(chessPieces)) {

            if (chessPieces.size() != 8) {
                throw new InvalidParameterException("Expected 8 chess pieces");
            }

        } else {

            chessPieces = createEmptyBoardRow();

        }

        return new ArrayList<>(chessPieces);
    }

    /**
     * Luo tyhjän shakkilaudan perustilanteessa (= aloitustilanne)
     *     Palauttaa 2-ulotteisen listan jossa on 8kpl vaakavektoreita
     *
     * @.pre true
     *
     * @.post RESULT != null &&
     *        RESULT.length == 8 &&
     *        FORALL(
     *            i : 0 <= i < RESULT.length;
     *            RESULT[i].length == 8 &&
     *            (i == 0 || i == 7) ?                                                -- Vektorin indeksit 1,7
     *            List.of("R", "N", "B", "Q", "K", "B", "N", "R").equals(RESULT[i]) :
     *            (i == 1 || i == 6) ?                                                -- Vektorin indeksit 2,6
     *            List.of("P", "P", "P", "P", "P", "P", "P", "P").equals(RESULT[i]) :
     *            (i == 2 || i == 3 || i == 4 || i == 5) ?                            -- Vektorin indeksit 2,3,4,5
     *            List.of("-", "-", "-", "-", "-", "-", "-", "-").equals(RESULT[i]) :
     *            false                                                               -- Looppi ei koskaan päädy tänne,
     *        )                                                                              voitaisiin paremmin toteuttaa
     *                                                                                       switch lausekkeella mutta
     *                                                                                       notaation takia tässä
     *                                                                                       if-else shorthand notaatiolla
     *
     */
    public static List<List<String>> createEmptyBoard() {

        List<List<String>> board = new ArrayList<>();

        board.add(createDefaultRoyalsBoardRow());

        board.add(createDefaultPawnBoardRow());

        board.add(createBoardRow(null));
        board.add(createBoardRow(null));
        board.add(createBoardRow(null));
        board.add(createBoardRow(null));

        board.add(createDefaultPawnBoardRow());

        board.add(createDefaultRoyalsBoardRow());

        return board;

    }

    /**
     * Luo kuninkaallisten vektorin nappuloita perustilanteessa (= aloitustilanne)
     *
     * @.pre true
     *
     * @.post List.of("R", "N", "B", "Q", "K", "B", "N", "R").equals(RESULT)
     *
     */
    public static List<String> createDefaultRoyalsBoardRow() {

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

    /**
     * Luo sotilaiden vektorin nappuloita perustilanteessa (= aloitustilanne)
     *
     * @.pre true
     *
     * @.post List.of("P", "P", "P", "P", "P", "P", "P", "P").equals(RESULT)
     *
     */
    public static List<String> createDefaultPawnBoardRow() {

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
     * Luo vektorin, joka on tyhjä nappuloista
     *
     * @.pre true
     *
     * @.post List.of("-", "-", "-", "-", "-", "-", "-", "-").equals(RESULT)
     *
     */
    public static List<String> createEmptyBoardRow() {

        return Arrays.asList(
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece,
                EmptyChessPiece
        );

    }

}
