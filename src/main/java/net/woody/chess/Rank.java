package net.woody.chess;

import net.woody.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private static final int BOARD_LENGTH = 8;

    private final List<Piece> pieces = new ArrayList<>(BOARD_LENGTH);

    public Rank() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            pieces.add(Piece.createBlank());
        }
    }

    public void add(int file, Piece piece) {
        pieces.set(file, piece);
    }

    public Piece find(int file) {
        if (file < 0 || size() <= file) {
            throw new ArrayIndexOutOfBoundsException("File number " + file + " is out of range!");
        }
        return pieces.get(file);
    }

    public int size() {
        return pieces.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (pieces.size() == 0) {
            return "........";
        }
        pieces.forEach(piece -> sb.append(piece.getRepresentation()));
        return sb.toString();
    }
}
