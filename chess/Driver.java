package chess;

import chess.Board.Space;

public class Driver {
    public static void main(String[] args) {
        Board board = new Board();
        board.dumpBoardState(System.out);

        Board board2 = new Board(board);
        board2.dumpBoardState(System.out);

        board.whiteTurn(Space.B1, Space.C3);
        board.dumpBoardState(System.out);
        board.whiteTurn(Space.C3, Space.E2);
        board.whiteTurn(Space.C3, Space.D5);
        board.whiteTurn(Space.D5, Space.E7);
        board.dumpBoardState(System.out);
        board.whiteTurn(Space.E7, Space.F5);
        board.dumpBoardState(System.out);
        board2 = new Board(board);
        board2.dumpBoardState(System.out);
    }
}
