package net.shion.chess.board;

import net.shion.chess.pieces.Piece;
import net.shion.chess.pieces.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static net.shion.chess.pieces.Piece.*;
import static net.shion.chess.pieces.Piece.Type.*;
import static net.shion.chess.pieces.Piece.Type.ROOK;

public class Rank {
    public static final int MAX_FILE = 8;

    private List<Piece> pieces = new ArrayList<>();

    private Rank() {

    }

    public List<Piece> pieces() {
        return Collections.unmodifiableList(pieces);
    }

    public static Rank createInitialRank8() {
        int rankIndex = 7;
        Rank rank8 = new Rank();
        rank8.addAll(Arrays.asList(
                createBlack(ROOK, new Position(0, rankIndex))
                , createBlack(KNIGHT, new Position(1, rankIndex))
                , createBlack(BISHOP, new Position(2, rankIndex))
                , createBlack(QUEEN, new Position(3, rankIndex))
                , createBlack(KING, new Position(4, rankIndex))
                , createBlack(BISHOP, new Position(5, rankIndex))
                , createBlack(KNIGHT, new Position(6, rankIndex))
                , createBlack(ROOK, new Position(7, rankIndex)))
        );
        return rank8;
    }

    public static Rank createInitialRank7() {
        int rankIndex = 6;
        Rank rank7 = new Rank();
        for (int file = 0; file < MAX_FILE; file++) {
            rank7.add(Piece.createBlack(PAWN, new Position(file, rankIndex)));
        }
        return rank7;
    }

    public static Rank createBlankRank(int rankIndex) {
        rankIndex--;
        Rank rank = new Rank();
        for (int file = 0; file < MAX_FILE; file++) {
            rank.add(Piece.createBlank(new Position(file, rankIndex)));
        }
        return rank;
    }

    public static Rank createInitialRank2() {
        int rankIndex = 1;
        Rank rank2 = new Rank();
        for (int file = 0; file < MAX_FILE; file++) {
            rank2.add(Piece.createWhite(PAWN, new Position(file, rankIndex)));
        }
        return rank2;
    }

    public static Rank createInitialRank1() {
        int rankindex = 0;
        Rank rank1 = new Rank();
        rank1.addAll(Arrays.asList(
                createWhite(ROOK, new Position(0, rankindex))
                , createWhite(KNIGHT, new Position(1, rankindex))
                , createWhite(BISHOP, new Position(2, rankindex))
                , createWhite(QUEEN, new Position(3, rankindex))
                , createWhite(KING, new Position(4, rankindex))
                , createWhite(BISHOP, new Position(5, rankindex))
                , createWhite(KNIGHT, new Position(6, rankindex))
                , createWhite(ROOK, new Position(7, rankindex)))
        );
        return rank1;
    }

    public int size() {
        return pieces.size();
    }

    public void add(final Piece piece) {
        pieces.add(piece);
    }

    public void addAll(final List<Piece> piece) {
        pieces.addAll(piece);
    }

    public long pieceCountOf(Color color, Type type) {
        long pieceCount = pieces.stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
        return pieceCount;
    }

    public Piece getPieceOf(int file) {
        return pieces.get(file);
    }

    public void set(int index, Piece piece) {
        pieces.set(index, piece);
    }

    public List<Piece> getPiecesOf(Color color) {
        List<Piece> piecesOfColor = pieces.stream()
                .filter(piece -> piece.getColor() == color)
                .collect(Collectors.toList());
        return piecesOfColor;
    }
}
