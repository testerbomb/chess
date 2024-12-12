package piece;

import java.util.ArrayList;


import chess.Board.Space;

/*
 * the pawn chess peice.
 */
public class Pawn extends Piece {

    public Pawn(String colorName) {
        super(Piece.colorFromString(colorName).isWhite ? "♙" : "♟", colorName, 1);
    }

    @Override
    public ArrayList<Space> movableSpaces(int letter, int number) {

        ArrayList<Space> result = new ArrayList<Space>();
        if (chess.Board.spaceInBoard(letter, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter, number + (this.getColor().isWhite ? 1 : -1)));
        }

        if (!this.moved()) {
            result.add(chess.Board.Space.getSpace(letter, number + (this.getColor().isWhite ? 2 : -2)));
        }

        return result;
    }

    @Override
    public ArrayList<Space> attackableSpaces(int letter, int number) {
        ArrayList<Space> result = new ArrayList<Space>();

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
