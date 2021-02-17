package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.pieces.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();
    private static final int BOARD_CELLS = 8;


    public void addPawn(Piece piece) {
        if (piece.getColor() == Color.WHITE)
            whitePawns.add(piece);
        else
            blackPawns.add(piece);

    }

    public int getPawnsSize() {
        return whitePawns.size() + blackPawns.size();
    }


    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        whitePawns.clear();
        blackPawns.clear();
        for (int i = 0; i < BOARD_CELLS; i++) {
            addPawn(new Piece());
            addPawn(new Piece(Color.BLACK));
        }
    }

    public String getPawnsResult(Color color) {
        if (color == Color.WHITE)
            return getPiecesToString(whitePawns);
        else
            return getPiecesToString(blackPawns);
    }

    private String getPiecesToString(List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

}
