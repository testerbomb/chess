package chess;

import java.util.Set;

import chess.Board.Space;

public abstract class Piece {
    private boolean moved;
    private Color color;
    private String character;

    public Piece(String character, String Color) {
        this.character = character;
        moved = false;
        this.color = colorFromString(Color);
    }

    abstract Set<Space> movableSpaces(int letter, int number);

    public void setMoved() {
        this.moved = true;
    }

    public boolean moved() {
        return moved;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return character;
    }

    protected static Color colorFromString(String colorName) {
        switch (colorName) {
            case "White":
                return Color.WHITE;
            case "Black":
                return Color.BLACK;
            default:
                throw new IllegalArgumentException();
        }
    }

    public enum Color {
        WHITE("White", true),
        BLACK("Black", false);

        final String colorName;
        final boolean isWhite;

        Color(String colorName, boolean isWhite) {
            this.colorName = colorName;
            this.isWhite = isWhite;
        }

    }
}
