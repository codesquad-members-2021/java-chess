package net.sanhee.chess;

import net.sanhee.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Pawn> pawns = new ArrayList<Pawn>();
    private final String defaultUnitRep = "........";
    private final Pawn[] whitePawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];
    private final Pawn[] blackPawn = new Pawn[Pawn.MAX_SPAWN_NUMBER];

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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            sb.append(pawns.get(i).getRepresentation());
        }

        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();


        for (int i = 8; i < pawns.size(); i++) {
            sb.append(pawns.get(i).getRepresentation());
        }

        return sb.toString();
    }
}
