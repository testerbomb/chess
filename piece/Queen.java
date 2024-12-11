package piece;

import java.util.HashSet;
import java.util.Set;

import chess.Board.Space;

/**
 * The Queen Piece
 */
public class Queen extends Piece {

    public Queen(String colorName) {
        super((Piece.colorFromString(colorName).isWhite ? "♕" : "♛"), colorName, 9);
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

        if (chess.Board.spaceInBoard(letter - 1, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter - 1, number + 1));
        }
        if (chess.Board.spaceInBoard(letter, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter, number + 1));
        }

        if (chess.Board.spaceInBoard(letter + 1, number + 1)) {
            result.add(chess.Board.Space.getSpace(letter + 1, number + 1));
        }

        if (chess.Board.spaceInBoard(letter - 1, number)) {
            result.add(chess.Board.Space.getSpace(letter - 1, number));
        }

        if (chess.Board.spaceInBoard(letter + 1, number)) {
            result.add(chess.Board.Space.getSpace(letter + 1, number));
        }

        if (chess.Board.spaceInBoard(letter - 1, number - 1)) {
            result.add(chess.Board.Space.getSpace(letter - 1, number - 1));
        }

        if (chess.Board.spaceInBoard(letter, number - 1)) {
            result.add(chess.Board.Space.getSpace(letter, number - 1));
        }

        if (chess.Board.spaceInBoard(letter + 1, number - 1)) {
            result.add(chess.Board.Space.getSpace(letter + 1, number - 1));
        }

        // North west
        for (int i = letter - 1, j = number + 1; (i < 8) && (j < 8); i--, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // north east

        for (int i = letter + 1, j = number + 1; (i < 8) && (j < 8); i++, j++) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south east

        for (int i = letter + 1, j = number - 1; (i < 8) && (j < 8); i++, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        // south west

        for (int i = letter - 1, j = number - 1; (i < 8) && (j < 8); i--, j--) {
            result.add(chess.Board.Space.getSpace(i, j));
        }

        return result;
    }

    @Override
    Set<Space> attackableSpaces(int letter, int number) {
        return movableSpaces(letter, number);
    }

    @Override
    public Piece clone() {
        Queen result = new Queen(this.getColor().colorName);
        if (this.moved()) {
            result.setMoved();
        }
        return result;
    }

}
