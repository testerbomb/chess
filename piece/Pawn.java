package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

public class Pawn extends Piece {

    public Pawn(String colorName) {
        super(Piece.colorFromString(colorName).equals(Color.WHITE) ? "♙" : "♟", colorName, 1);
    }

    @Override
    Set<Space> movableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();
        if (!this.moved()) {
            result.add(chess.Board.Space.getSpace(letter, number + 2));
        }

        if (chess.Board.spaceInBoard(letter, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter, number + 1));
        }

        return result;
    }

    @Override
    Set<Space> attackableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();

        if (chess.Board.spaceInBoard(letter - 1, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter - 1, number + 1));
        }

        if (chess.Board.spaceInBoard(letter + 1, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter + 1, number + 1));
        }

        return result;
    }

}
