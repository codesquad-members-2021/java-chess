package net.sanhee.chess;

import net.sanhee.pieces.*;
import net.sanhee.pieces.property.UnitColor;
import net.sanhee.utils.StringUtils;

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
        for (Piece piece : pieces) {
            if (piece.isPawn(color)) {
                pawnLine.append(piece.getRepresentation());
            }
        }
        return pawnLine.toString();
    }

    public void initialize() {
        initializeRoyalLine(UnitColor.BLACK);
        initializePawnLine(UnitColor.BLACK);
        initializeNoPieceLine();
        initializeNoPieceLine();
        initializeNoPieceLine();
        initializeNoPieceLine();
        initializePawnLine(UnitColor.WHITE);
        initializeRoyalLine(UnitColor.WHITE);
    }

    private void initializeRoyalLine(UnitColor unitColor) {
        // Rook-Knight-Bishop-Queen-King-Bishop-Knight-Rook
        add(Piece.createRook(unitColor));
        add(Piece.createKnight(unitColor));
        add(Piece.createBishop(unitColor));
        add(Piece.createQueen(unitColor));
        add(Piece.createKing(unitColor));
        add(Piece.createBishop(unitColor));
        add(Piece.createKnight(unitColor));
        add(Piece.createRook(unitColor));
    }

    private void initializePawnLine(UnitColor unitColor) {
        final int MAX_SPAWN = 8;
        for (int i = 0; i < MAX_SPAWN; i++) {
            pieces.add(Piece.createPawn(unitColor));
        }
    }

    private void initializeNoPieceLine() {
        final int MAX_SPAWN = 8;
        for (int i = 0; i < MAX_SPAWN; i++) {
            pieces.add(Piece.createNoPiece());
        }
    }

    public int pieceCount() {
        int count = 0;
        for (Piece piece : pieces) {
            if (!piece.isColor(UnitColor.NOCOLOR)) {
                count++;
            }
        }
        return count;
    }

    public StringBuilder showBoard(int index, int count) {
        final StringBuilder boardString = new StringBuilder();
        final int LINE_OF_PIECE = 8;

        if (index == 63) {
            return boardString.append(findPiece(index).getRepresentation()).append(StringUtils.NEWLINE);
        }

        if (count == LINE_OF_PIECE) {
            count = 0;
            return boardString.append(findPiece(index).getRepresentation()).append(StringUtils.NEWLINE).append(showBoard(index + 1, count + 1));
        }
        return boardString.append(findPiece(index).getRepresentation()).append(showBoard(index + 1, count + 1));
    }

}
