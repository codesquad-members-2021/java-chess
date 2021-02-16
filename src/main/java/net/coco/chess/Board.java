package net.coco.chess;

import net.coco.pieces.Pawn;
import net.coco.pieces.PawnEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private static final int BOARD_CELLS=8;



    public void addWhitePawn(Pawn pawn) {
        if (pawn.getColor() == PawnEnum.WHITE)
            whitePawns.add(pawn);
        else
            System.out.println("화이트 색상을 넣어주세요.");
    }

    public void addBlackPawn(Pawn pawn) {
        if (pawn.getColor() == PawnEnum.BLACK)
            blackPawns.add(pawn);
        else
            System.out.println("블랙 색상을 넣어주세요.");
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
        for (int i = 0; i < BOARD_CELLS; i++) {
            whitePawns.add(new Pawn(PawnEnum.WHITE));
            blackPawns.add(new Pawn(PawnEnum.BLACK));
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
