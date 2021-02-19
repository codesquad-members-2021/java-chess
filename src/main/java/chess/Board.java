package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Pawn;

public class Board {
    private List<Pawn> pawns = new ArrayList<>();
    private List<Pawn> whitePawns = new ArrayList<>(8);
    private List<Pawn> blackPawns = new ArrayList<>(8);

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public int getWhitePawnsSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    private void initialize() {
        Pawn whitePawn = new Pawn();
        Pawn blackPawn = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        for (int i = 0; i < 8; i++) {
            whitePawns.add(whitePawn);
            blackPawns.add(blackPawn);
        }
    }

}
