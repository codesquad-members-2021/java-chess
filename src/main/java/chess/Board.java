package chess;

import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public void addBlack(Piece piece) {
        blackPieces.add(piece);
    }

    public void addWhite(Piece piece) {
        whitePieces.add(piece);
    }

    public int size() {
        return whitePieces.size() + blackPieces.size();
    }

    public Piece findWhite(int index) {
        return whitePieces.get(index);
    }

    public Piece findBlack(int index) {
        return blackPieces.get(index);
    }

    void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhite(new Pawn(Piece.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
            addBlack(new Pawn(Piece.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
        }
    }

    String getWhitePawnsResult() {
        return getPiecesResult(whitePieces);
    }

    String getBlackPawnsResult() {
        return getPiecesResult(blackPieces);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("........\n");
        sb.append(getBlackPawnsResult()).append("\n");
        for (int i = 0; i < BOARD_SIZE - 4; i++) {
            sb.append("........\n");
        }
        sb.append(getWhitePawnsResult()).append("\n");
        sb.append("........\n");

        System.out.println(sb.toString());
    }
}
