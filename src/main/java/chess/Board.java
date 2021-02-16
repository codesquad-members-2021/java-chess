package chess;

import pieces.Piece;

import java.util.*;

import static utils.StringUtils.*;

public class Board {
    private final List<Piece> blackPieces;
    private final List<Piece> whitePieces;
    final int BOARD_SIZE = 8;

    public Board() {
        blackPieces = new ArrayList<>();
        whitePieces = new ArrayList<>();
    }

    private void addWhitePiece(Piece piece) {
        whitePieces.add(piece);
    }

    private void addBlackPiece(Piece piece) {
        blackPieces.add(piece);
    }

    public int numberOfPieces() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeWhitePieces() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePiece(Piece.createWhitePawn());
        }
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
        for (int i = 0; i < BOARD_SIZE; i++) {
            addBlackPiece(Piece.createBlackPawn());
        }
    }

    private String getWhitePiecesToPrint() {
        return getPiecesToPrint(whitePieces);
    }

    private String getBlackPiecesToPrint() {
        return getPiecesToPrint(blackPieces);
    }

    private String getPiecesToPrint(List<Piece> pieces) {
        StringBuilder piecesToPrint = new StringBuilder();
        for (Piece piece : pieces) {
            piecesToPrint.append(piece.getRepresentation());
        }
        return piecesToPrint.toString();
    }

    public String getResultToPrint() {
        String blankRank = appendNewLine("........");
        StringBuilder result = new StringBuilder();
        result.append(appendNewLine(getBlackPiecesToPrint()))
                .append(blankRank).append(blankRank).append(blankRank).append(blankRank)
                .append(appendNewLine(getWhitePiecesToPrint()));
        return result.toString();
    }
}

