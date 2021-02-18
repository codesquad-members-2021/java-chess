package net.coco.chess;

import net.coco.pieces.Pawn;
import net.coco.pieces.PawnEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private static final int BOARD_CELLS = 8;


    public void addPawn(Pawn pawn) {
        if (pawn.getColor() == PawnEnum.WHITE)
            whitePawns.add(pawn);
        else
            blackPawns.add(pawn);

    }

    public int getPawnsSize() {
        return whitePawns.size() + blackPawns.size();
    }


    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public void initialize() {
        whitePawns.clear();
        blackPawns.clear();
        for (int i = 0; i < BOARD_CELLS; i++) {
            addPawn(new Pawn());
            addPawn(new Pawn(PawnEnum.BLACK));
        }
    }

    public String getPawnsResult(PawnEnum pawnEnum) {
        if (pawnEnum == PawnEnum.WHITE)
            return getPawnsToString(whitePawns);
        else
            return getPawnsToString(blackPawns);
    }

    private String getPawnsToString(List<Pawn> Pawns) {
        return Pawns.stream()
                .map(pawn -> String.valueOf(pawn.getRepresentation()))
                .collect(Collectors.joining());
    }

}
