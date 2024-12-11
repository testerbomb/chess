package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/**
 * The Bishop Piece.
 */
public class Bishop extends Piece {

    public Bishop(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♗" : "♝"), colorName, 3);
    }

    @Override
    Set<Space> movableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();

        // North west
        for (int i = letter - 1, j = number + 1; (i < 8) && (j < 8); i--, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // north east

        for (int i = letter + 1, j = number + 1; (i < 8) && (j < 8); i++, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south east

        for (int i = letter + 1, j = number - 1; (i < 8) && (j < 8); i++, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south west

        for (int i = letter - 1, j = number - 1; (i < 8) && (j < 8); i--, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        return result;

    }

    @Override
    Set<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

}
