package chess;

public class Driver {
    public static void main(String[] args) {
        Board board = new Board();
        board.dumpBoardState(System.out);
        System.out.println(board.whites.toString() + "\n" + board.blacks.toString());

        Board board2 = new Board(board);
        board2.dumpBoardState(System.out);
        System.out.println(board2.whites.toString() + "\n" + board2.blacks.toString());
    }
}
