package piece;

import java.util.ArrayList;

import chess.Board.Space;

/**
 * The King piece.
 */
public class King extends Piece {

    public King(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♔" : "♚"), colorName, Integer.MAX_VALUE);
    }

    @Override
    public ArrayList<Space> movableSpaces(int currLetter, int currnumber) {
        ArrayList<Space> result = new ArrayList<Space>();

        if (chess.Board.spaceInBoard(currLetter - 1, currnumber + 1)) {
            result.add(chess.Board.Space.getSpace(currLetter - 1, currnumber + 1));
        }
        if (chess.Board.spaceInBoard(currLetter, currnumber + 1)) {
            result.add(chess.Board.Space.getSpace(currLetter, currnumber + 1));
        }

        if (chess.Board.spaceInBoard(currLetter + 1, currnumber + 1)) {
            result.add(chess.Board.Space.getSpace(currLetter + 1, currnumber + 1));
        }

        if (chess.Board.spaceInBoard(currLetter - 1, currnumber)) {
            result.add(chess.Board.Space.getSpace(currLetter - 1, currnumber));
        }

        if (chess.Board.spaceInBoard(currLetter + 1, currnumber)) {
            result.add(chess.Board.Space.getSpace(currLetter + 1, currnumber));
        }

        if (chess.Board.spaceInBoard(currLetter - 1, currnumber - 1)) {
            result.add(chess.Board.Space.getSpace(currLetter - 1, currnumber - 1));
        }

        if (chess.Board.spaceInBoard(currLetter, currnumber - 1)) {
            result.add(chess.Board.Space.getSpace(currLetter, currnumber - 1));
        }

        if (chess.Board.spaceInBoard(currLetter + 1, currnumber - 1)) {
            result.add(chess.Board.Space.getSpace(currLetter + 1, currnumber - 1));
        }
        return result;
    }

    @Override
    public ArrayList<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
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
