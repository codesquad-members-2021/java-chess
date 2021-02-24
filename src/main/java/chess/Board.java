package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class Board {
    private static int PAWN_NUM = 8;
    private List<Piece> whitePawns = new ArrayList<>(PAWN_NUM);
    private List<Piece> blackPawns = new ArrayList<>(PAWN_NUM);

    boolean addWhitePawn(Piece piece) {
        if (piece.getColor().equals(Piece.WHITE)) {
            whitePawns.add(piece);
            return true;
        }
        return false;
    }

    boolean addBlackPawn(Piece piece) {
        if (piece.getColor().equals(Piece.BLACK)) {
            blackPawns.add(piece);
            return true;
        }
        return false;
    }

    public int getWhitePawnsSize() {
        return whitePawns.size();
    }

    public int getBlackPawnsSize() {
        return blackPawns.size();
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(blackPawns);
    }

    private String getPawnsResult(List<Piece> pieces) {
        StringBuilder sb = new StringBuilder();
        for (Piece aPiece : pieces) {
            sb.append(aPiece.getRepresentation());
        }
        return sb.toString();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    void initialize() {
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        for (int i = 0; i < PAWN_NUM; i++) {
            addWhitePawn(whitePawn);
            addBlackPawn(blackPawn);
        }
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlackPawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getBlankLine()));
        sb.append(appendNewLine(getWhitePawnsResult()));
        sb.append(appendNewLine(getBlankLine()));
        System.out.println(sb.toString());
    }

    private String getBlankLine() {
        return "........";
    }
}
