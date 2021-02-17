package chess;

import pieces.Color;
import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public String getWhitePawnsResult() {
        StringBuffer whiteBuffer = new StringBuffer(8);
        for (Pawn whitePawn : whitePawns) {
            whiteBuffer.append(whitePawn.getColorRepresentation());
        }
        return whiteBuffer.toString();

    }

    public String getBlackPawnsResult() {
        StringBuffer blackBuffer = new StringBuffer(8);
        for (Pawn blackPawn : blackPawns) {
            blackBuffer.append(blackPawn.getColorRepresentation());
        }
        return blackBuffer.toString();

    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            addWhitePawn(pawn);
        }
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            addBlackPawn(pawn);
        }
    }

    public void addBlackPawn(Pawn pawn) {
        blackPawns.add(pawn);
    }

    public void addWhitePawn(Pawn pawn) {
        whitePawns.add(pawn);
    }


}
