package piece;

import java.util.Set;

import chess.Board.Space;

public abstract class Piece {
    private boolean moved;
    private Color color;
    private String character;
    private int weight;

    public Piece(String character, String Color, int weight) {
        this.character = character;
        moved = false;
        this.color = colorFromString(Color);
        this.weight = weight;
    }

    abstract Set<Space> movableSpaces(int letter, int number);

    abstract Set<Space> attackableSpaces(int letter, int number);

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

    public int getWeight() {
        return weight;
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
