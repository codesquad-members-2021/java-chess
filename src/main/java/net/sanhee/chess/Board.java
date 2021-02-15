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
        StringBuilder whitePawnLine = new StringBuilder();

        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            whitePawnLine.append(pawns.get(i).getRepresentation());
        }

        return whitePawnLine.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnLine = new StringBuilder();


        for (int i = 8; i < pawns.size(); i++) {
            blackPawnLine.append(pawns.get(i).getRepresentation());
        }

        return blackPawnLine.toString();
    }

    public void initialize() {

        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            whitePawn[i] = new Pawn(UnitColor.WHITE);
            pawns.add(whitePawn[i]);
        }

        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            blackPawn[i] = new Pawn(UnitColor.BLACK);
            pawns.add(blackPawn[i]);
        }

        boardList.add(defaultUnitRep.split(""));
        boardList.add(getBlackPawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(getWhitePawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));
    }
}
