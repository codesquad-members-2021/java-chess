package chess;

import piece.Piece;
import piece.attribute.*;

import java.util.*;

import static piece.PieceFactory.createPiece;
import static util.StringUtil.NEWLINE;

public class Board {
    private final Map<Position, Piece> squares = new LinkedHashMap<>();
    private final int BOARD_SIZE = 8;

    public void addPiece(char x, int y, Piece piece) {
        squares.put(new Position(x, y), piece);
    }

    public void initialize() {
        initPiecesExceptPawns(Color.BLACK, 8);
        initPawns(Color.BLACK, 7);
        initBlankSquares(6);
        initBlankSquares(5);
        initBlankSquares(4);
        initBlankSquares(3);
        initPawns(Color.WHITE, 2);
        initPiecesExceptPawns(Color.WHITE, 1);
    }

    private void initRank(Color color, int rank, Type type) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addPiece((char) (i + 'a'), rank, createPiece(color, type));
        }
    }

    private void initBlankSquares(int rank) {
        initRank(Color.NO_COLOR, rank, Type.BLANK);
    }

    private void initPawns(Color color, int rank) {
        initRank(color, rank, Type.PAWN);
    }

    private void initPiecesExceptPawns(Color color, int rank) {
        addPiece('a', rank, createPiece(color, Type.ROOK));
        addPiece('b', rank, createPiece(color, Type.KNIGHT));
        addPiece('c', rank, createPiece(color, Type.BISHOP));
        addPiece('d', rank, createPiece(color, Type.QUEEN));
        addPiece('e', rank, createPiece(color, Type.KING));
        addPiece('f', rank, createPiece(color, Type.BISHOP));
        addPiece('g', rank, createPiece(color, Type.KNIGHT));
        addPiece('h', rank, createPiece(color, Type.ROOK));
    }

    public String getResultToPrint() {
        StringBuilder result = new StringBuilder();
        int count = BOARD_SIZE * BOARD_SIZE;
        for (Piece piece : squares.values()) {
            result.append(piece.getRepresentation()).append(" ");
            count--;
            if (count % BOARD_SIZE == 0) {
                result.append("  ").append(count / BOARD_SIZE + 1).append(NEWLINE);
            }
        }
        result.append(NEWLINE).append("a b c d e f g h ");
        return result.toString();
    }

    public int getNumberOfPieces(Color color, Type type) {
        return (int) squares.values()
                .stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
    }
}

