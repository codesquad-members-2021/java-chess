package net.sally.chess;

import net.sally.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import static net.sally.util.StringUtils.*;

public class Board {
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();

    public static int BOARD_SIZE = 8;
    private static final String BLANK = "........";

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePawns.add(Piece.createWhitePawn());
            blackPawns.add(Piece.createBlackPawn());
        }
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());

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
        if (piece.isWhite()) {
            whitePieces.add(piece);
        }
    }

    private void addBlackPiece(Piece piece) {
        if (piece.isBlack()) {
            blackPieces.add(piece);
        }
    }

    public String getWhitePawnsResult() {
        return getPiecesResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPiecesResult(blackPawns);
    }

    public String getWhitePiecesResult() { return getPiecesResult(whitePieces); }

    public String getBlackPiecesResult() { return getPiecesResult(blackPieces); }

    private String getPiecesResult(List<Piece> pieces) {
        StringBuilder piecesResult = new StringBuilder();
        for (Piece p : pieces) {
            piecesResult.append(p.getRepresentation());
        }
        return piecesResult.toString();
    }

    public int getWhitePawnSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public int getWhitePiecesSize() { return whitePieces.size(); }

    public int getBlackPiecesSize() { return blackPieces.size(); }

    public int pieceCount() { return getBlackPawnsSize() + getWhitePawnSize() + getWhitePiecesSize() + getBlackPiecesSize(); }

    public String showBoard() {
        StringBuilder printer = new StringBuilder();
        printer.append(appendNewLine(getBlackPiecesResult()))
                .append(appendNewLine(getBlackPawnsResult()))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(BLANK))
                .append(appendNewLine(getWhitePawnsResult()))
                .append(appendNewLine(getWhitePiecesResult()));
        return printer.toString();
    }
}
