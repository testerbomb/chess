package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/**
 * The rook class.
 */
public class Rook extends Piece {

    public Rook(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♖" : "♜"), colorName, 5);
    }

    @Override
    Set<Space> movableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();
        // north
        for (int i = letter, j = number + 1; j < 8; j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south
        for (int i = letter, j = number - 1; j >= 0; j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // east

        for (int i = letter - 1, j = number; i >= 0; i--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }
        // west
        for (int i = letter + 1, j = number; i >= 0; i++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        return result;
    }

    @Override
    Set<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

}
