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
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Pawn> pawns) {
        StringBuilder sb = new StringBuilder();
        for (char representation : representations(pawns)) {
            sb.append(representation);
        }
        return sb.toString();
    }

    private char[] representations(List<Pawn> pawns) {
        char[] representations = new char[pawns.size()];
        for (int i = 0; i < pawns.size(); i++) {
            representations[i] = pawns.get(i).getColorRepresentation();
        }
        return representations;
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

    public void print() {
        StringBuilder result = new StringBuilder();
        result = emptyBoard(result);
        result.replace(9 * 1, 9 * 1 + getBlackPawnsResult().length(), getWhitePawnsResult());
        result.replace(9 * 6, 9 * 6 + getBlackPawnsResult().length(), getBlackPawnsResult());
        System.out.println(result);

    }

    private StringBuilder emptyBoard(StringBuilder result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                result.append(".");
                if (column == 7) {
                    result.append("\n");
                }
            }
        }
        return result;
    }

}
