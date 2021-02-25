package net.sanhee.chess;

import net.sanhee.pieces.*;
import net.sanhee.pieces.property.UnitColor;
import net.sanhee.pieces.property.UnitType;
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
            if (piece.isYou(color, UnitType.PAWN)) {
                pawnLine.append(piece.getRepresentation());
            }
        }
        return pawnLine.toString();
    }

    public void initialize() {
        blackRoyalLineInit();
        pawnLineInit(UnitColor.BLACK);
        noneLineInit();
        noneLineInit();
        noneLineInit();
        noneLineInit();
        pawnLineInit(UnitColor.WHITE);
        whiteRoyalUnitInit();
    }

    private void blackRoyalLineInit() {
        // Rook-Knight-Bishop-Queen-King-Bishop-Knight-Rook
        add(new Rook(UnitColor.BLACK));
        add(new Knight(UnitColor.BLACK));
        add(new Bishop(UnitColor.BLACK));
        add(new Queen(UnitColor.BLACK));
        add(new King(UnitColor.BLACK));
        add(new Bishop(UnitColor.BLACK));
        add(new Knight(UnitColor.BLACK));
        add(new Rook(UnitColor.BLACK));
    }

    private void whiteRoyalUnitInit() {
        // Rook-Knight-Bishop-Queen-King-Bishop-Knight-Rook
        add(new Rook(UnitColor.WHITE));
        add(new Knight(UnitColor.WHITE));
        add(new Bishop(UnitColor.WHITE));
        add(new Queen(UnitColor.WHITE));
        add(new King(UnitColor.WHITE));
        add(new Bishop(UnitColor.WHITE));
        add(new Knight(UnitColor.WHITE));
        add(new Rook(UnitColor.WHITE));
    }

    private void pawnLineInit(UnitColor unitColor) {
        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            pieces.add(PieceFactory.createPawn(unitColor));
        }
    }

    private void noneLineInit() {
        for (int i = 0; i < Pawn.MAX_SPAWN_NUMBER; i++) {
            pieces.add(PieceFactory.createNone(UnitColor.NONE));
        }
    }

    public int pieceCount() {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.isColor(UnitColor.NONE)) {
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
