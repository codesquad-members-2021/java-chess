package net.woody.chess;

import net.woody.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final int BOARD_LENGTH = 8;

    private final List<Pawn> pawns = new ArrayList<>(BOARD_LENGTH);

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn find(int file) {
        if (file < 0 || size() <= file) {
            throw new ArrayIndexOutOfBoundsException("File number " + file + " is out of range!");
        }
        return pawns.get(file);
    }

    public int size() {
        return pawns.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (pawns.size() == 0) {
            return "........";
        }
        pawns.forEach(pawn -> sb.append(pawn.getRepresentation()));
        return sb.toString();
    }
}
