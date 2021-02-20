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

    private List<Piece> getPiecesByColor(Piece piece) {
        if (piece.isWhite()) {
            return whitePieces;
        }
        return blackPieces;
    }

    private void addPiece(Piece piece) {
        getPiecesByColor(piece).add(piece);
    }

    public int pieceNum() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        initializeWhitePieces();
        initializeBlackPieces();
    }

    private void initializeWhitePieces() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addPiece(Piece.createWhitePawn());
        }
        addPiece(Piece.createWhiteRook());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteQueen());
        addPiece(Piece.createWhiteKing());
        addPiece(Piece.createWhiteBishop());
        addPiece(Piece.createWhiteKnight());
        addPiece(Piece.createWhiteRook());
    }

    private void initializeBlackPieces() {
        addPiece(Piece.createBlackRook());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackQueen());
        addPiece(Piece.createBlackKing());
        addPiece(Piece.createBlackBishop());
        addPiece(Piece.createBlackKnight());
        addPiece(Piece.createBlackRook());
        for (int i = 0; i < BOARD_SIZE; i++) {
            addPiece(Piece.createBlackPawn());
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

