package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/**
 * The King piece.
 */
public class King extends Piece {

    public King(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♔" : "♚"), colorName, Integer.MAX_VALUE);
    }

    @Override
    Set<Space> movableSpaces(int currLetter, int currnumber) {
        HashSet<Space> result = new HashSet<>();

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
    Set<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

}
