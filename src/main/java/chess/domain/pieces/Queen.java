package chess.domain.pieces;

public class Queen extends Piece {
    private static final Queen whiteQueen = new Queen(Color.WHITE);
    private static final Queen blackQueen = new Queen(Color.BLACK);

    private Queen(Color color) {
        super(color);
    }

    public static Queen ofWhite() {
        return whiteQueen;
    }

    public static Queen ofBlack() {
        return blackQueen;
    }

    @Override
    char getIcon() {
        return 'Q';
    }
}
