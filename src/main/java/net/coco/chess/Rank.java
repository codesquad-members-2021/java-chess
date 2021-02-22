package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private final List<Piece> pieces = new ArrayList<>();

    public int size() {
        return pieces.size();
    }

    public void clear() {
        pieces.clear();
    }

    public List<Piece> getList() {
        return pieces;
    }

    public void addWhitePawn(Piece piece) {
        if (!PieceValid.isPawn(piece) || !piece.isWhite()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        pieces.add(piece);
    }

    public void addBlackPawn(Piece piece) {
        if (!PieceValid.isPawn(piece) || !piece.isBlack()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        pieces.add(piece);
    }

    public void addOtherWhitePiece(Piece piece) {
        if (!PieceValid.isOtherPiece(piece) || !piece.isWhite()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        pieces.add(piece);
    }

    public void addOtherBlackPiece(Piece piece) {
        if (!PieceValid.isOtherPiece(piece) || !piece.isBlack()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        pieces.add(piece);
    }
}
