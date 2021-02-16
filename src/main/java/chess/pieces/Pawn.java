package chess.pieces;

public class Pawn {
    private final Color color;

    public enum Color {
        WHITE('p'),
        BLACK('P');

        private final char pawns;

        Color(char pawns) {
            this.pawns = pawns;
        }

        public char getRepresentation() {
            return pawns;
        }
    }

    Pawn() {
        this.color = Color.WHITE;
    }

    public Pawn(Color color) {
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return color.getRepresentation();
    }

}
