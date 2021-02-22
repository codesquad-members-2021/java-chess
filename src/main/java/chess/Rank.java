package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Type;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private List<Piece> pieces = new ArrayList<>(Board.BOARD_SIZE);

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(int rankIndex) {
        return pieces.get(rankIndex);
    }

    public void addWhitePieces(Piece piece) {
        if (piece.isWhite()) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void addBlackPieces(Piece piece) {
        if (piece.isBlack()) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }

    public void addBlank(Piece piece) {
        if (piece.getType() == Type.BLANK) {
            pieces.add(piece);
            return;
        }
        getAddErrorMessage();
    }
    private void getAddErrorMessage(){
        System.out.println("알 수 없는 color의 piece입니다.");
        System.out.println("add에 실패하였습니다.");
    }
}
