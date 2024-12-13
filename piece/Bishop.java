package piece;

import java.util.ArrayList;

import chess.Board.Space;

/**
 * The Bishop Piece.
 */
public class Bishop extends Piece {

    public Bishop(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♗" : "♝"), colorName, 3);
    }

    @Override
    public ArrayList<Space> movableSpaces(int letter, int number) {
        ArrayList<Space> result = new ArrayList<Space>();

        // North west
        for (int i = letter - 1, j = number + 1; (i >= 0) && (j < 8); i--, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // north east

        for (int i = letter + 1, j = number + 1; (i < 8) && (j < 8); i++, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south east

        for (int i = letter + 1, j = number - 1; (i < 8) && (j >= 0); i++, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south west

        for (int i = letter - 1, j = number - 1; (i >= 0) && (j >= 0); i--, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        return result;

    }

    @Override
    public ArrayList<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

    @Override
    public Piece clone() {
        Bishop result = new Bishop(this.getColor().colorName);
        if (this.moved()) {
            result.setMoved();
        }
        return result;
    }

}
