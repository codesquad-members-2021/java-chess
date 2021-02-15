package net.sky.pieces;

public class Pawn {

    private final Color color;

    private final Representation representation;

    public enum Color {WHITE, BLACK}

    public enum Representation {
        p('p'), P('P');

        private final char value;

        Representation(char value) {
            this.value = value;
        }

        public char getValue() {
            return this.value;
        }
    }

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = Representation.p;
    }

    public Pawn(Color color, Representation representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public Representation getRepresentation() {
        return representation;
    }

}
