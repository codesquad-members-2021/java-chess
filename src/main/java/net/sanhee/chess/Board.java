package net.sanhee.chess;

import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.UnitColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<Pawn>();
    private final String defaultUnitRep = "........";
    private final Pawn[] whitePawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];
    private final Pawn[] blackPawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];
    private final List<String[]> boardList = new ArrayList<>();

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
        StringBuilder PawnLine = new StringBuilder();

        switch (color) {
            case WHITE:
                for (int i = 0; i < 8; i++) {
                    PawnLine.append(pawns.get(i).getRepresentation());
                }
                break;
            case BLACK:
                for (int i = 8; i < 16; i++) {
                    PawnLine.append(pawns.get(i).getRepresentation());
                }
                break;
        }

        return PawnLine.toString();
    }

    public void initialize() {

        arrayPawnInit(whitePawn, UnitColor.WHITE);
        arrayPawnInit(blackPawn, UnitColor.BLACK);

        for (int i = 0; i < 8; i++) {
            if (i == 1 || i == 6) {
                boardList.add(getBlackPawnsResult().split(""));
            } else {
                boardList.add(defaultUnitRep.split(""));
            }
        }

    }

    public void arrayPawnInit(Pawn[] arrayPawns, UnitColor color) {
        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            arrayPawns[i] = new Pawn(color);
            pawns.add(arrayPawns[i]);
        }
    }
}
