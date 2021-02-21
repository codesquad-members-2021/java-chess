package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.List;

public class OtherWhitePieces {
    private final List<Piece> otherWhitePieces = new ArrayList<>();

    public void add(Piece piece) {
        if (!PieceValid.isPawn(piece) || !piece.isWhite()) {
            System.out.println("넣지 못했습니다. 요구 조건을 확인하세요.");
            return;
        }
        otherWhitePieces.add(piece);
    }

    public int size() {
        return otherWhitePieces.size();
    }

    public void clear() {
        otherWhitePieces.clear();
    }

    public List<Piece> getList() {
        return otherWhitePieces;
    }
}
