package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import piece.Piece;
import piece.Color;
import piece.Type;
import piece.Position;

import static piece.PieceCreator.*;
import static util.StringUtils.appendNewLine;

public class Rank {
    private static final int BOARD_SIZE = 8;
    private final List<Piece> pieces = new ArrayList<>(BOARD_SIZE);

    private void add(Piece piece) {
        pieces.add(piece);
    }

    private List<Piece> getPieces() {
        return pieces;
    }

    public void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    public int countPieces(Color color, Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.verifyPiece(color, type)) {
                countPiece++;
            }
        }
        return countPiece;
    }

    public static Rank initializeWhitePieces(int rankIndex) {
        Rank rank = new Rank();
        rank.add(createWhiteRook(new Position(0, rankIndex)));
        rank.add(createWhiteKnight(new Position(1, rankIndex)));
        rank.add(createWhiteBishop(new Position(2, rankIndex)));
        rank.add(createWhiteQueen(new Position(3, rankIndex)));
        rank.add(createWhiteKing(new Position(4, rankIndex)));
        rank.add(createWhiteBishop(new Position(5, rankIndex)));
        rank.add(createWhiteKnight(new Position(6, rankIndex)));
        rank.add(createWhiteRook(new Position(7, rankIndex)));
        return rank;
    }

    public static Rank initializeBlackPieces(int rankIndex) {
        Rank rank = new Rank();
        rank.add(createBlackRook(new Position(0, rankIndex)));
        rank.add(createBlackKnight(new Position(1, rankIndex)));
        rank.add(createBlackBishop(new Position(2, rankIndex)));
        rank.add(createBlackQueen(new Position(3, rankIndex)));
        rank.add(createBlackKing(new Position(4, rankIndex)));
        rank.add(createBlackBishop(new Position(5, rankIndex)));
        rank.add(createBlackKnight(new Position(6, rankIndex)));
        rank.add(createBlackRook(new Position(7, rankIndex)));
        return rank;
    }

    public static Rank initializeWhitePawns(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.add(createWhitePawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    public static Rank initializeBlackPawns(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.add(createBlackPawn(new Position(i, rankIndex)));
        }
        return rank;
    }

    public static Rank initializeBlankLine(int rankIndex) {
        Rank rank = new Rank();
        for(int i = 0; i < BOARD_SIZE; i++) {
            rank.add(createBlank(new Position(i, rankIndex)));
        }
        return rank;
    }

    public Piece findPiece(int xPos) {
        return pieces.get(xPos);
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> piecesByColor = new ArrayList<>();
        for (Piece piece : pieces) {
            piece.addPiecesByColor(color, piecesByColor);
        }
        return Collections.unmodifiableList(piecesByColor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : getPieces()) {
            sb.append(piece.getRepresentation());
        }
        return appendNewLine(sb.toString());
    }
}