package chess;

import pieces.Color;
import pieces.Pawn;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Pawn> whitePawns = new ArrayList<>();
    private List<Pawn> blackPawns = new ArrayList<>();
    private static final int BOARD_FILE = 8;

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
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (char representation : getRepresentations(pawns)) {
            sb.append(representation);
        }
        return sb.toString();
    }

    private char[] getRepresentations(List<Pawn> pawns) {
        char[] representations = new char[pawns.size()];
        for (int i = 0; i < pawns.size(); i++) {
            representations[i] = pawns.get(i).getRepresentation();
        }
        return representations;
    }

    public void addWhitePawn(Pawn pawn) {
        if (pawn.getColor() != Color.WHITE) {
            throw new InvalidParameterException("pawn의 색을 확인해 주세요");
        }
        whitePawns.add(pawn);
    }

    public void addBlackPawn(Pawn pawn) {
        if (pawn.getColor() != Color.BLACK) {
            throw new InvalidParameterException("pawn의 색을 확인해 주세요");
        }
        blackPawns.add(pawn);
    }

    public void initialize() {
        for (int i = 0; i < BOARD_FILE; i++) {
            addWhitePawn(new Pawn(Color.WHITE));
            addBlackPawn(new Pawn(Color.BLACK));
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        String emptyLine = "........";
        result.append(emptyLine)
                .append("\n")
                .append(getWhitePawnsResult())
                .append("\n")
                .append(emptyLine)
                .append("\n")
                .append(emptyLine)
                .append("\n")
                .append(emptyLine)
                .append("\n")
                .append(emptyLine)
                .append("\n")
                .append(getBlackPawnsResult())
                .append("\n")
                .append(emptyLine);
        return result.toString();
    }
}
