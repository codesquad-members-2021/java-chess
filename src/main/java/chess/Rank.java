package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

import static utils.StringUtils.appendNewLine;

class Rank {
    private static final int BOARD_SIZE = 8;

    private final List<Piece> pieces = new ArrayList<>(BOARD_SIZE);

    void addPiece(Piece piece) {
        pieces.add(piece);
    }

    List<Piece> getPieces() {
        return pieces;
    }

    public void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    int countPieces(Color color, Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.verifyPiece(color, type)) {
                countPiece++;
            }
        }
        return countPiece;
    }

    static Rank initializeWhitePieces(int rankIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createWhiteRook(new Position(0, rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(1, rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(2, rankIndex)));
        rank.addPiece(Piece.createWhiteQueen(new Position(3, rankIndex)));
        rank.addPiece(Piece.createWhiteKing(new Position(4, rankIndex)));
        rank.addPiece(Piece.createWhiteBishop(new Position(5, rankIndex)));
        rank.addPiece(Piece.createWhiteKnight(new Position(6, rankIndex)));
        rank.addPiece(Piece.createWhiteRook(new Position(7, rankIndex)));
        return rank;
    }

    static Rank initializeBlackPieces(int rankIndex) {
        Rank rank = new Rank();
        rank.addPiece(Piece.createBlackRook(new Position(0, rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(1, rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(2, rankIndex)));
        rank.addPiece(Piece.createBlackQueen(new Position(3, rankIndex)));
        rank.addPiece(Piece.createBlackKing(new Position(4, rankIndex)));
        rank.addPiece(Piece.createBlackBishop(new Position(5, rankIndex)));
        rank.addPiece(Piece.createBlackKnight(new Position(6, rankIndex)));
        rank.addPiece(Piece.createBlackRook(new Position(7, rankIndex)));
        return rank;
    }

    static Rank initializeWhitePawns(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createWhitePawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    static Rank initializeBlackPawns(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlackPawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    static Rank initializeBlankLine(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.addPiece(Piece.createBlank(new Position(i, rankIndex)));
        }
        return rank;
    }

    public int size() {
        return pieces.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }

    Piece findPiece(int xPos) {
        return pieces.get(xPos);
    }
}