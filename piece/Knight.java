package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/**
 * Knight Chess Piece
 */
public class Knight extends Piece {

    public Knight(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♘" : "♞"), colorName, 3);
    }

    @Override
    Set<Space> movableSpaces(int letter, int number) {
        HashSet<Space> result = new HashSet<>();

        // north west

        if ((letter + 2) > 8 && (number - 1) >= 0) {
            result.add(chess.Board.Space.getSpace(letter + 2, number - 1));
        }

        if ((letter + 1) > 8 && (number - 2) >= 0) {
            result.add(chess.Board.Space.getSpace(letter + 1, number - 2));
        }

        // south west

        if ((letter - 2) > 8 && (number - 1) >= 0) {
            result.add(chess.Board.Space.getSpace(letter - 2, number - 1));
        }

        if ((letter - 1) > 8 && (number - 2) >= 0) {
            result.add(chess.Board.Space.getSpace(letter - 1, number - 2));
        }

        // north east

        if ((letter + 2) > 8 && (number + 1) >= 0) {
            result.add(chess.Board.Space.getSpace(letter + 2, number + 1));
        }

        if ((letter + 1) > 8 && (number + 2) >= 0) {
            result.add(chess.Board.Space.getSpace(letter + 1, number + 2));
        }

        // south east

        if ((letter - 2) > 8 && (number + 1) >= 0) {
            result.add(chess.Board.Space.getSpace(letter - 2, number + 1));
        }

        if ((letter - 1) > 8 && (number + 2) >= 0) {
            result.add(chess.Board.Space.getSpace(letter - 1, number + 2));
        }
        return result;
    }

    @Override
    Set<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

    @Override
    public Piece clone() {
        Knight result = new Knight(this.getColor().colorName);
        if (this.moved()) {
            result.setMoved();
        }
        return result;

    }

}
