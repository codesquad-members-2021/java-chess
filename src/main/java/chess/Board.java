package chess;

import pieces.Pawn;
import pieces.Pawn.Color;
import java.util.*;

public class Board {
    private final List<Pawn> blackPawns;
    private final List<Pawn> whitePawns;

    public Board() {
        blackPawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return whitePawns.get(index);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }
}
