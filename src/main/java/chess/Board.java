package chess;

import pieces.Pawn;
import pieces.Pawn.Color;

import java.util.*;

import static utils.StringUtils.*;

public class Board {
    private final List<Pawn> blackPawns;
    private final List<Pawn> whitePawns;
    private final int BOARD_SIZE = 8;

    public Board() {
        blackPawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
    }

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    public String getWhitePawnsToPrint() {
        return getPawnsToPrint(whitePawns);
    }

    public String getBlackPawnsToPrint() {
        return getPawnsToPrint(blackPawns);
    }

    private String getPawnsToPrint(List<Pawn> pawns) {
        StringBuilder pawnsToPrint = new StringBuilder();
        for (Pawn pawn : pawns) {
            pawnsToPrint.append(pawn.getColor().getRepresentation());
        }
        return pawnsToPrint.toString();
    }

    public String getResultToPrint() {
        String emptyLine = appendNewLine("........");
        StringBuilder result = new StringBuilder();
        result.append(emptyLine)
                .append(appendNewLine(getBlackPawnsToPrint()))
                .append(emptyLine).append(emptyLine).append(emptyLine).append(emptyLine)
                .append(appendNewLine(getWhitePawnsToPrint()))
                .append(emptyLine);
        return result.toString();
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
        return blackPawns.get(index);
    }

    public int size() {
        return whitePawns.size() + blackPawns.size();
    }

    public int whitePawnsSize() {
        return whitePawns.size();
    }

    public int blackPawnsSize() {
        return blackPawns.size();
    }

}

