package net.coco.chess;

import net.coco.pieces.Pawn;
import net.coco.pieces.PawnEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();



    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int getWhitePawnSize() {
        return whitePawns.size();
    }

    public int getBlackPawnSize() {
        return blackPawns.size();
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
        for (int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn(PawnEnum.WHITE_COLOR));
            blackPawns.add(new Pawn(PawnEnum.BLACK_COLOR));
        }
    }

    public String getPawnsResult(PawnEnum pawnEnum) {
        if (pawnEnum == PawnEnum.WHITE_COLOR)
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
