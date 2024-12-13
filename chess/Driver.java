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
        System.out.println(board.map.get(Space.B2).movableSpaces(1, 1));
        System.out.println(board.map.get(Space.A2).movableSpaces(0, 1));
        board.whiteTurn(Space.A2, Space.A4);
        board.dumpBoardState(System.out);
        board.whiteTurn(Space.A4, Space.A5);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.A5, Space.A6);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.A6, Space.A7);
        board.dumpBoardState(System.out);
        board.whiteTurn(Space.A6, Space.B7);
        board.dumpBoardState(System.out);
        System.out.println(board.map.get(Space.A1).movableSpaces(0, 0));
        board.whiteTurn(Space.A1, Space.A6);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.A6, Space.A8);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.A6, Space.A7);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.A7, Space.E7);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.C1, Space.A3);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.C1, Space.A3);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.B2, Space.B4);
        board.dumpBoardState(System.out);

        board.whiteTurn(Space.C1, Space.A3);
        board.dumpBoardState(System.out);

    }
}
