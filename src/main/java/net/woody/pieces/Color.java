package net.woody.pieces;

public enum Color {

    WHITE, BLACK, NOCOLOR;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
