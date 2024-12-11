package chess;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;
import piece.Piece.Color;

/**
 * Chess Board Class defining a chess board as a 8x8 board each space only knows
 * its peice.
 *
 * @author Timothy Stout
 */
public class Board {
  protected HashMap<Space, Piece> map;
  protected HashSet<Piece> whites;
  protected HashSet<Piece> blacks;

  public Board(Board other) {
    map = new HashMap<>();
    whites = new HashSet<>();
    blacks = new HashSet<>();

    Iterator<Piece> pIterator = other.boardIterator();
    List<Space> l = Arrays.asList(Space.values());
    Collections.reverse(l);
    for (int i = 0; i < 64; i++) {
      Piece curr = pIterator.next();
      if (curr != null) {
        map.put(l.get(i), curr.clone());
        if (curr.getColor() == Color.WHITE) {
          whites.add(curr);
        } else {
          blacks.add(curr);
        }
      }
    }
  }

  public Board() {
    map = new HashMap<>();
    whites = new HashSet<>();
    blacks = new HashSet<>();
    map.put(Space.E1, new King("White"));
    map.put(Space.D1, new Queen("White"));
    map.put(Space.E8, new King("Black"));
    map.put(Space.D8, new Queen("Black"));

    map.put(Space.A2, new Pawn("White"));
    map.put(Space.B2, new Pawn("White"));
    map.put(Space.C2, new Pawn("White"));
    map.put(Space.D2, new Pawn("White"));
    map.put(Space.E2, new Pawn("White"));
    map.put(Space.F2, new Pawn("White"));
    map.put(Space.G2, new Pawn("White"));
    map.put(Space.H2, new Pawn("White"));

    map.put(Space.B1, new Knight("White"));
    map.put(Space.G1, new Knight("White"));

    map.put(Space.B8, new Knight("Black"));
    map.put(Space.G8, new Knight("Black"));

    map.put(Space.A7, new Pawn("Black"));
    map.put(Space.B7, new Pawn("Black"));
    map.put(Space.C7, new Pawn("Black"));
    map.put(Space.D7, new Pawn("Black"));
    map.put(Space.E7, new Pawn("Black"));
    map.put(Space.F7, new Pawn("Black"));
    map.put(Space.G7, new Pawn("Black"));
    map.put(Space.H7, new Pawn("Black"));

    map.put(Space.A1, new Rook("White"));
    map.put(Space.H1, new Rook("White"));

    map.put(Space.A8, new Rook("Black"));
    map.put(Space.H8, new Rook("Black"));

    map.put(Space.C1, new Bishop("White"));
    map.put(Space.F1, new Bishop("White"));

    map.put(Space.C8, new Bishop("Black"));
    map.put(Space.F8, new Bishop("Black"));
    fillSets();
  }

  private void fillSets() {
    whites.add(map.get(Space.A1));
    whites.add(map.get(Space.B1));
    whites.add(map.get(Space.C1));
    whites.add(map.get(Space.D1));
    whites.add(map.get(Space.E1));
    whites.add(map.get(Space.F1));
    whites.add(map.get(Space.G1));
    whites.add(map.get(Space.H1));
    whites.add(map.get(Space.A2));
    whites.add(map.get(Space.B2));
    whites.add(map.get(Space.C2));
    whites.add(map.get(Space.D2));
    whites.add(map.get(Space.E2));
    whites.add(map.get(Space.F2));
    whites.add(map.get(Space.G2));
    whites.add(map.get(Space.H2));

    blacks.add(map.get(Space.A8));
    blacks.add(map.get(Space.B8));
    blacks.add(map.get(Space.C8));
    blacks.add(map.get(Space.D8));
    blacks.add(map.get(Space.E8));
    blacks.add(map.get(Space.F8));
    blacks.add(map.get(Space.G8));
    blacks.add(map.get(Space.H8));
    blacks.add(map.get(Space.A7));
    blacks.add(map.get(Space.B7));
    blacks.add(map.get(Space.C7));
    blacks.add(map.get(Space.D7));
    blacks.add(map.get(Space.E7));
    blacks.add(map.get(Space.F7));
    blacks.add(map.get(Space.G7));
    blacks.add(map.get(Space.H7));
  }

  /**
   * move is capture if it the map contains the key(empty spaces are not
   * contained.
   */
  public boolean moveIsCapture(Space s) {
    return map.containsKey(s);
  }

  /**
   * The point of the Enum is that every space exists checks for null.
   * 
   * @param s the space
   * @return
   */
  public static boolean spaceInBoard(Space s) {
    return s != null;
  }

  /**
   * overloaded method in order to be used for before creation of
   * 
   * @param letter
   * @param number
   * @return
   */
  public static boolean spaceInBoard(int letter, int number) {
    return ((letter >= 0 && letter < 8) && (number >= 0 && number < 8));
  }

  /**
   * dumps board in a human readable form.
   * 
   * @param o the output file to be printed to
   */
  public void dumpBoardState(PrintStream o) {
    Iterator<Piece> pIterator = new PieceIterator(map);
    LocalDateTime now = LocalDateTime.now();
    o.printf("%s\n", now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    o.print("----".repeat(8) + "-\n");
    for (int i = 0; i < 8; i++) {
      String line = "|";
      for (int j = 0; j < 8; j++) {
        Piece curr = pIterator.next();
        if (curr == null) {
          line = "|   " + line;
        } else {
          line = String.format("| %s ", curr.toString()) + line;
        }

      }
      o.print(line + "\n");
      o.print("----".repeat(8) + "-\n");
    }

  }

  /**
   * iterates through all spaces returning null for an empty space.
   */
  public Iterator<Piece> boardIterator() {
    return new PieceIterator(map);
  }

  /**
   * Defines every single space on the chess board.
   */
  public enum Space {
    A1(0, 0), B1(1, 0), C1(2, 0), D1(3, 0), E1(4, 0), F1(5, 0), G1(6, 0), H1(7, 0),

    A2(0, 1), B2(1, 1), C2(2, 1), D2(3, 1), E2(4, 1), F2(5, 1), G2(6, 1), H2(7, 1),

    A3(0, 2), B3(1, 2), C3(2, 2), D3(3, 2), E3(4, 2), F3(5, 2), G3(6, 2), H3(7, 2),

    A4(0, 3), B4(1, 3), C4(2, 3), D4(3, 3), E4(4, 3), F4(5, 3), G4(6, 3), H4(7, 3),

    A5(0, 4), B5(1, 4), C5(2, 4), D5(3, 4), E5(4, 4), F5(5, 4), G5(6, 4), H5(7, 4),

    A6(0, 5), B6(1, 5), C6(2, 5), D6(3, 5), E6(4, 5), F6(5, 5), G6(6, 5), H6(7, 5),

    A7(0, 6), B7(1, 6), C7(2, 6), D7(3, 6), E7(4, 6), F7(5, 6), G7(6, 6), H7(7, 6),

    A8(0, 7), B8(1, 7), C8(2, 7), D8(3, 7), E8(4, 7), F8(5, 7), G8(6, 7), H8(7, 7);

    private final int letter;
    private final int number;

    Space(int letter, int number) {
      this.letter = letter;
      this.number = number;
    }

    public static Space getSpace(int letter, int number) {
      for (Space space : Space.values()) {
        if (space.getLetter() == letter && space.getNumber() == number) {
          return space;
        }
      }
      throw new IllegalArgumentException("Cords not in board");
    }

    private int getLetter() {
      return letter;
    }

    private int getNumber() {
      return number;
    }

  }

  protected class PieceIterator implements Iterator<Piece> {
    private Iterator<Space> spaceIterator;

    private HashMap<Space, Piece> iteratorMap;
    private HashMap<Space, Piece> original;

    @SuppressWarnings("unchecked")
    PieceIterator(HashMap<Space, Piece> map) {
      List<Space> l = Arrays.asList(Space.values());
      Collections.reverse(l);
      spaceIterator = l.iterator();
      original = map;
      iteratorMap = (HashMap<Space, Piece>) map.clone();
    }

    @Override
    public boolean hasNext() {
      return spaceIterator.hasNext();
    }

    public Piece next() {
      if (!iteratorMap.equals(original)) {
        throw new ConcurrentModificationException();
      }
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Space currSpace = spaceIterator.next();

      if (iteratorMap.containsKey(currSpace)) {
        return iteratorMap.get(currSpace);
      } else {
        return null;
      }

    }
  }

}
