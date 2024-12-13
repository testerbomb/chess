package piece;

import java.util.ArrayList;

import chess.Board.Space;

/**
 * The rook class.
 */
public class Rook extends Piece {

    public Rook(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♖" : "♜"), colorName, 5);
    }

    @Override
    public ArrayList<Space> movableSpaces(int letter, int number) {
        ArrayList<Space> result = new ArrayList<Space>();
        // north
        for (int i = letter, j = number + 1; j < 7; j++) {

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
        for (int i = letter + 1, j = number; i < 7; i++) {
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
        Rook result = new Rook(this.getColor().colorName);
        if (this.moved()) {
            result.setMoved();
        }
        return result;
    }

}
