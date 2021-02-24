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
        for (Piece pawn : pieces) {
            boolean classCheck = pawn.getClass().getSimpleName().equalsIgnoreCase(UnitType.PAWN.name());
            if (pawn.isColor(color) && classCheck) {
                pawnLine.append(pawn.getRepresentation());
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

    public String showBoard() {
        StringBuilder boardString = new StringBuilder();
        final int LINE_OF_PIECE = 8;
        int count = 1;
        for (int col = 0; col < pieces.size(); col++) {
            if (count == LINE_OF_PIECE) {
                boardString.append(findPiece(col).getRepresentation()).append(StringUtils.NEWLINE);
                count = 1;
            } else {
                boardString.append(findPiece(col).getRepresentation());
                count++;
            }
        }
        return boardString.toString();
    }
}
