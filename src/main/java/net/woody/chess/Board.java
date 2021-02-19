package net.woody.chess;

import net.woody.pieces.Color;
import net.woody.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private final List<Rank> board = new ArrayList<>(BOARD_LENGTH);
    private int size = 0;

    public Board() {
        IntStream.range(0, BOARD_LENGTH).forEach(i -> board.add(new Rank()));
    }

    public void add(Pawn pawn) {
        int rank = getPawnRank(pawn);
        getRank(rank).add(pawn);
        size++;
    }

    private int getPawnRank(Pawn newPawn) {
        return (newPawn.getColor() == Color.WHITE) ? Pawn.WHITE_PAWN_RANK : Pawn.BLACK_PAWN_RANK;
    }

    public Rank getRank(int rank) {
        if (rank < 0 || board.size() <= rank) {
            throw new ArrayIndexOutOfBoundsException("Rank number " + rank + " is out of range!");
        }
        return board.get(rank);
    }

    public Pawn findPawn(int rank, int file) {
        return getRank(rank).find(file);
    }

    public void initialize() {
        Rank blackPawns = getRank(Pawn.BLACK_PAWN_RANK);
        Rank whitePawns = getRank(Pawn.WHITE_PAWN_RANK);

        IntStream.range(0, BOARD_LENGTH).forEach(i -> {
            blackPawns.add(new Pawn(Color.BLACK.colorName()));
            whitePawns.add(new Pawn());
            size += 2;
        });
    }

    public String getWhitePawnsResult() {
        return getRank(Pawn.WHITE_PAWN_RANK).toString();
    }

    public String getBlackPawnsResult() {
        return getRank(Pawn.BLACK_PAWN_RANK).toString();
    }

    public int size() {
        return size;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board) {
            sb.append(rank.toString()).append('\n');
        }
        return sb.toString();
    }
}
