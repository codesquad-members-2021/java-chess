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
        char[] representations = toRepresentations(whitePawns);
        for (char representation : representations) {
            whiteBuffer.append(representation);
        }
        return whiteBuffer.toString();
    }

    public String getBlackPawnsResult() {
        StringBuffer blackBuffer = new StringBuffer(8);
        char[] representations = toRepresentations(blackPawns);
        for (char representation : representations) {
            blackBuffer.append(representation);
        }
        return blackBuffer.toString();
    }

    private char[] toRepresentations(List<Pawn> pawns) {
        char[] representations = new char[pawns.size()];
        for (int i = 0; i < representations.length; i++) {
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
        StringBuffer result = new StringBuffer();
        result = emptyBoard(result);
        result.replace(9 * 1, 9 * 1 + getBlackPawnsResult().length(), getWhitePawnsResult());
        result.replace(9 * 6, 9 * 6 + getBlackPawnsResult().length(), getBlackPawnsResult());
        System.out.println(result);

    }

    private StringBuffer emptyBoard(StringBuffer result) {
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
