package chess;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

public class King extends Piece {

    public King(String colorName) {
        super((Piece.colorFromString(colorName).equals(Piece.Color.WHITE) ? "♔" : "♚"), colorName);
    }

    @Override
    Set<Space> movableSpaces(int currLetter, int currnumber) {
        HashSet<Space> result = new HashSet<>();

        if (Board.spaceInBoard(currLetter - 1, currnumber + 1)) {
            result.add(Board.Space.getSpace(currLetter - 1, currnumber + 1));
        }
        if (Board.spaceInBoard(currLetter, currnumber + 1)) {
            result.add(Board.Space.getSpace(currLetter, currnumber + 1));
        }

        if (Board.spaceInBoard(currLetter + 1, currnumber + 1)) {
            result.add(Board.Space.getSpace(currLetter + 1, currnumber + 1));
        }

        if (Board.spaceInBoard(currLetter - 1, currnumber)) {
            result.add(Board.Space.getSpace(currLetter - 1, currnumber));
        }

        if (Board.spaceInBoard(currLetter + 1, currnumber)) {
            result.add(Board.Space.getSpace(currLetter + 1, currnumber));
        }

        if (Board.spaceInBoard(currLetter - 1, currnumber - 1)) {
            result.add(Board.Space.getSpace(currLetter - 1, currnumber - 1));
        }

        if (Board.spaceInBoard(currLetter, currnumber - 1)) {
            result.add(Board.Space.getSpace(currLetter, currnumber - 1));
        }

        if (Board.spaceInBoard(currLetter + 1, currnumber - 1)) {
            result.add(Board.Space.getSpace(currLetter + 1, currnumber - 1));
        }
        return result;
    }
}
