package net.honux.chess;

import net.honux.chess.pieces.Piece;

import java.util.ArrayList;

public class Board {

    private static final int BOARD_LENGTH = 8;

    private ArrayList<Piece> whitePawns = new ArrayList<>();
    private ArrayList<Piece> blackPawns = new ArrayList<>();

    public void add(Piece pawn) {
        distinguishPawnsColor(pawn).add(pawn);
    }

    public int size(Piece pawn) {
        return distinguishPawnsColor(pawn).size();
    }

    public Piece findPawn(Piece pawn, int index) {
        return distinguishPawnsColor(pawn).get(index);
    }

    private ArrayList<Piece> distinguishPawnsColor(Piece pawn) {
        if (pawn.getColor() == Piece.WHITE_COLOR)
            return whitePawns;
        else
            return blackPawns;
    }

    void initialize() {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            whitePawns.add(new Piece(Piece.WHITE_COLOR, Piece.White.PAWN.representation));
            blackPawns.add(new Piece(Piece.BLACK_COLOR, Piece.Black.PAWN.representation));
        }
    }

    public String getWhitePawnsResult() {
        return listPawnsToSingleLine(whitePawns);
    }

    public String getBlackPawnsResult() {
        return listPawnsToSingleLine(blackPawns);
    }

    public String getBlankLine() {
        return "........";
    }

    private String listPawnsToSingleLine(ArrayList<Piece> whichGroupOfPawns) {
        StringBuilder sb = new StringBuilder();

        for (Piece p : whichGroupOfPawns)
            sb.append(p.getRepresentation());

        return sb.toString();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlackPawnsResult());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        sb.append(getWhitePawnsResult());
        sb.append("\n");
        sb.append(getBlankLine());
        sb.append("\n");
        System.out.println(sb.toString());
    }
}

