package chess.domain.pieces;

public class Queen extends Piece {
    private static final Queen whiteQueen = new Queen(Color.WHITE);
    private static final Queen blackQueen = new Queen(Color.BLACK);

    private Queen(Color color) {
        super(color);
    }

    public static Queen of(Color color) {
        return color.equals(Color.WHITE)
                ? whiteQueen
                : blackQueen;
    }

    @Override
    char getIcon() {
        return 'Q';
    }
}
