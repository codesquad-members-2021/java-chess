package net.sanhee.chess;

import net.sanhee.pieces.Pawn;
import net.sanhee.pieces.Piece;
import net.sanhee.pieces.PieceFactory;
import net.sanhee.pieces.property.UnitColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Piece> pieces = new ArrayList<>();

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int size() {
        return pieces.size();
    }

    public Piece findPiece(int idx) {
        return pieces.get(idx);
    }

    public String getWhitePawnsResult() {
        return appendPawnRep(UnitColor.WHITE);
    }

    public String getBlackPawnsResult() {
        return appendPawnRep(UnitColor.BLACK);
    }

    public String appendPawnRep(UnitColor color) {
        StringBuilder pawnLine = new StringBuilder();
        for (Piece pawn : pieces) {
            if (pawn.isColor(color)) {
                pawnLine.append(pawn.getRepresentation());
            }
        }
        return pawnLine.toString();
    }

    public void initialize() {
        arrayPawnInit(UnitColor.WHITE);
        arrayPawnInit(UnitColor.BLACK);
    }

    private void arrayPawnInit(UnitColor unitColor) {
        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            pieces.add(PieceFactory.createPawn(unitColor));
        }
    }

    public String print() {
        String defaultUnitRep = "........";

        StringBuilder displayBoard = new StringBuilder();
        List<String[]> boardList = new ArrayList<>();

        boardList.add(defaultUnitRep.split(""));
        boardList.add(getBlackPawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(defaultUnitRep.split(""));
        boardList.add(getWhitePawnsResult().split(""));
        boardList.add(defaultUnitRep.split(""));


        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                displayBoard.append(boardList.get(row)[col]);
            }
            displayBoard.append("\n");
        }

        return displayBoard.toString();
    }

    public int pieceCount() {
        return 0;
    }

    public String showBoard() {
        return "";
    }
}
