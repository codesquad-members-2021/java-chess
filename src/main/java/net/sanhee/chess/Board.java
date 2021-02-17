package net.sanhee.chess;

import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.UnitColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<Pawn>();
    private final String defaultUnitRep = "........";

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int idx) {
        return pawns.get(idx);
    }

    public String getWhitePawnsResult() {
        return appendPawnRep(UnitColor.WHITE);
    }

    public String getBlackPawnsResult() {
        return appendPawnRep(UnitColor.BLACK);
    }

    public String appendPawnRep(UnitColor color) {
        StringBuilder pawnLine = new StringBuilder();
        for (Pawn pawn : pawns) {
            if (pawn.isColor(color)) {
                pawnLine.append(pawn.getRepresentation());
            }
        }
        return pawnLine.toString();
    }

    public void initialize() {
        Pawn[] whitePawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];
        Pawn[] blackPawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];
        arrayPawnInit(whitePawn, UnitColor.WHITE);
        arrayPawnInit(blackPawn, UnitColor.BLACK);
    }

    private void arrayPawnInit(Pawn[] arrayPawns, UnitColor color) {
        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            arrayPawns[i] = new Pawn(color);
            pawns.add(arrayPawns[i]);
        }
    }

    public String print() {

        StringBuilder displayBoard = new StringBuilder();
        List<String[]> boardList = new ArrayList<>();

        boardList.add(defaultUnitRep.split(""));
        boardList.add(getBlackPawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(getWhitePawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));


        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                displayBoard.append(boardList.get(row)[col]);
            }
            displayBoard.append("\n");
        }

        return displayBoard.toString();
    }
}
