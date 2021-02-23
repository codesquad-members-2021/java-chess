package chess;

import pieces.Piece;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
            addBlackPawn(Piece.createBlackPawn());
        }
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void addWhitePawn(Piece pawn) {
        if (pawn.isWhite() && pawn.isPawn())
            whitePawns.add(pawn);
    }

    private void addBlackPawn(Piece pawn) {
        if (pawn.isBlack() && pawn.isPawn())
            blackPawns.add(pawn);
    }

    private void initializeWhitePieces() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    private void initializeBlackPieces() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    private void addWhitePiece(Piece piece) {
        if (piece.isWhite() && !piece.isPawn())
            whitePieces.add(piece);
    }

    private void addBlackPiece(Piece piece) {
        if (piece.isBlack() && !piece.isPawn())
            blackPieces.add(piece);
    }

    public String getWhitePawnsResult() {
        return getPiecesRepresentations(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesRepresentations(blackPawns);
    }

    public String getWhitePiecesResult() {
        return getPiecesRepresentations(whitePieces);
    }

    public String getBlackPiecesResult() {
        return getPiecesRepresentations(blackPieces);
    }

    private String getPiecesRepresentations(List<Piece> pieces) {
        StringBuilder piecesResult = new StringBuilder();
        for (Piece piece : pieces)
            piecesResult.append(piece.getRepresentation());
        return piecesResult.toString();
    }

    public int size() {
        return blackPawns.size() + whitePawns.size() + blackPieces.size() + whitePieces.size();
    }

    public String printBoard() {
        StringBuilder result = new StringBuilder();
        String empty = appendNewLine("........");
        result.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(empty)
                .append(empty)
                .append(empty)
                .append(empty)
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));
        return result.toString();
    }
}
