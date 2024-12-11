package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/*
 * the pawn chess peice.
 */
public class Pawn extends Piece {

    public Pawn(String colorName) {
        super(Piece.colorFromString(colorName).isWhite ? "♙" : "♟", colorName, 1);
    }

    @Override
    Set<Space> movableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();
        if (!this.moved()) {
            result.add(chess.Board.Space.getSpace(letter, number + (this.getColor().isWhite ? 2 : -2)));
        }

        if (chess.Board.spaceInBoard(letter, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter, number + (this.getColor().isWhite ? 1 : -1)));
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

    @Override
    public Piece clone() {
        Pawn result = new Pawn(this.getColor().colorName);
        if (this.moved()) {
            result.setMoved();
        }
        return result;
    }

}
