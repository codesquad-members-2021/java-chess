package net.jung.chess;

import java.util.*;

import static net.jung.chess.Piece.*;

public class Rank {
    public static final int MAX_PIECES_IN_RANK = 8;
    private List<Piece> pieces = new ArrayList<>();

    public int rankPieceSize() {
        int size = 0;
        for (Piece piece : pieces) {
            if (piece.isPiece()) {
                size++;
            }
        }
        return size;
    }


    public void addWhitePiece(Piece piece) {
        if (piece.isWhite()) {
            pieces.add(piece);
        }
    }

    public void addBlackPiece(Piece piece) {
        if (piece.isBlack()) {
            pieces.add(piece);
        }
    }

    public static Rank initializeWhitePawnRank() {
        Rank whitePawnRank = new Rank();
        for (int i = 0; i < MAX_PIECES_IN_RANK; i++) {
            whitePawnRank.addWhitePiece(createWhitePawn());
        }
        return whitePawnRank;
    }

    public static Rank initializeBlackPawnRank() {
        Rank blackPawnRank = new Rank();
        for (int i = 0; i < MAX_PIECES_IN_RANK; i++) {
            blackPawnRank.addBlackPiece(createBlackPawn());
        }
        return blackPawnRank;
    }


    public static Rank initializeWhitePieceRank() {
        Rank whitePieceRank = new Rank();

        whitePieceRank.addWhitePiece(createWhiteRook());
        whitePieceRank.addWhitePiece(createWhiteKnight());
        whitePieceRank.addWhitePiece(createWhiteBishop());
        whitePieceRank.addWhitePiece(createWhiteQueen());
        whitePieceRank.addWhitePiece(createWhiteKing());
        whitePieceRank.addWhitePiece(createWhiteBishop());
        whitePieceRank.addWhitePiece(createWhiteKnight());
        whitePieceRank.addWhitePiece(createWhiteRook());

        return whitePieceRank;
    }

    public static Rank initializeBlackPieceRank() {
        Rank blackPieceRank = new Rank();

        blackPieceRank.addBlackPiece(createBlackRook());
        blackPieceRank.addBlackPiece(createBlackKnight());
        blackPieceRank.addBlackPiece(createBlackBishop());
        blackPieceRank.addBlackPiece(createBlackQueen());
        blackPieceRank.addBlackPiece(createBlackKing());
        blackPieceRank.addBlackPiece(createBlackBishop());
        blackPieceRank.addBlackPiece(createBlackKnight());
        blackPieceRank.addBlackPiece(createBlackRook());

        return blackPieceRank;
    }

    public static Rank initializeBlankRank() {
        Rank blankRank = new Rank();

        for (int i = 0; i < MAX_PIECES_IN_RANK; i++) {
            blankRank.pieces.add(createBlank());
        }
        return blankRank;
    }

    public Piece getPiece(int index) {
        return pieces.get(index);
    }

    public String rankLayoutToString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < pieces.size(); i++) {
            strBuilder.append(getPiece(i).getRepresentation());
        }
        return strBuilder.toString();
    }

    public void replacePiece(int fileIndex, Piece piece) {
        pieces.set(fileIndex, piece);
    }

}
