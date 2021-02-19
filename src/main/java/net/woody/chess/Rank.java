package net.woody.chess;

import net.woody.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rank {
    private static final int BOARD_LENGTH = 8;

    private final int rank;
    private final List<Pawn> pawns = new ArrayList<>(BOARD_LENGTH);

    public Rank(int rank) {
        this.rank = rank;
        initializePawnsWithNull();
    }

    private void initializePawnsWithNull() {
        IntStream.rangeClosed(0, BOARD_LENGTH).forEach(i -> pawns.add(null));
    }

    public void set(int file, Pawn pawn) {
        pawns.set(file, pawn);
    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : pawns) {
            char represent = (pawn == null) ? '.' : pawn.getRepresentation();
            sb.append(represent);
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
