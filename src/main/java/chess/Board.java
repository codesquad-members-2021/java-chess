package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final String NEW_LINE = "\n";
    private static final String EMPTY = "........" + NEW_LINE;
    private List<Piece> whitePawns = new ArrayList<>();
    private List<Piece> blackPawns = new ArrayList<>();

    public void initialize() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addWhitePawn(new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION));
            addBlackPawn(new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION));
        }
    }

    public void addWhitePawn(Piece pawn) {
        if (checkPawnColor(pawn, Piece.WHITE_COLOR))
            whitePawns.add(pawn);
    }

    public void addBlackPawn(Piece pawn) {
        if (checkPawnColor(pawn, Piece.BLACK_COLOR))
            blackPawns.add(pawn);
    }

    private boolean checkPawnColor(Piece pawn, String color) {
        return pawn.getColor().equals(color);
    }

    public String getWhitePawnsResult() {
        return getPawnRepresentations(whitePawns);
    }

    public String getBlackPawnsResult() {
        return getPawnRepresentations(blackPawns);
    }

    private String getPawnRepresentations(List<Piece> pawns) {
        StringBuilder pawnsResult = new StringBuilder();
        for (Piece pawn : pawns)
            pawnsResult.append(pawn.getRepresentation());
        return pawnsResult.toString();
    }

    public Piece findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Piece findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public int size() {
        return blackPawns.size() + whitePawns.size();
    }

    public String printBoard() {
        StringBuilder result = new StringBuilder();
        result.append(EMPTY)
                .append(getWhitePawnsResult())
                .append(NEW_LINE)
                .append(EMPTY)
                .append(EMPTY)
                .append(EMPTY)
                .append(EMPTY)
                .append(getBlackPawnsResult())
                .append(NEW_LINE)
                .append(EMPTY);

        return result.toString();
    }
}
