package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    public static final int BOARD_SIZE = 8;
    private static final String BLANK_LINE = "........";

    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();
    private final List<Piece> whitePawns = new ArrayList<>();
    private final List<Piece> blackPawns = new ArrayList<>();

    public void addWhite(Piece piece) {
        if (piece.isWhite()) {
            whitePieces.add(piece);
        }
    }

    public void addBlack(Piece piece) {
        if (piece.isBlack()) {
            blackPieces.add(piece);
        }
    }

    public void addWhitePawn(Piece piece) {
        if (piece.isWhite()) {
            whitePawns.add(piece);
        }
    }

    public void addBlackPawn(Piece piece) {
        if (piece.isBlack()) {
            blackPawns.add(piece);
        }
    }

    public int size() {
        return whitePieces.size()
                + blackPieces.size()
                + whitePawns.size()
                + blackPawns.size();
    }

    public Piece findWhite(int index) {
        return whitePieces.get(index);
    }

    public Piece findBlack(int index) {
        return blackPieces.get(index);
    }

    void initialize() {
        addWhitePieces();
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        addBlackPieces();
    }

    private void addWhitePieces() {
        addWhite(Piece.createWhiteRook());
        addWhite(Piece.createWhiteKnight());
        addWhite(Piece.createWhiteBishop());
        addWhite(Piece.createWhiteQueen());
        addWhite(Piece.createWhiteKing());
        addWhite(Piece.createWhiteBishop());
        addWhite(Piece.createWhiteKnight());
        addWhite(Piece.createWhiteRook());
    }

    private void addBlackPieces() {
        addBlack(Piece.createBlackRook());
        addBlack(Piece.createBlackKnight());
        addBlack(Piece.createBlackBishop());
        addBlack(Piece.createBlackQueen());
        addBlack(Piece.createBlackKing());
        addBlack(Piece.createBlackBishop());
        addBlack(Piece.createBlackKnight());
        addBlack(Piece.createBlackRook());
    }

    private String getWhitePawnsResult() {
        return getPiecesResult(whitePawns);
    }

    private String getBlackPawnsResult() {
        return getPiecesResult(blackPawns);
    }

    private String getWhitePiecesResult() {
        return getPiecesResult(whitePieces);
    }

    private String getBlackPiecesResult() {
        return getPiecesResult(blackPieces);
    }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieces) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(BLANK_LINE))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));

        return sb.toString();
    }

}
