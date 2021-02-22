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

    public static Rank initializeWhitePieces() {
        Rank rank = new Rank();
        rank.addWhitePieces(Piece.createWhiteRook());
        rank.addWhitePieces(Piece.createWhiteKnight());
        rank.addWhitePieces(Piece.createWhiteBishop());
        rank.addWhitePieces(Piece.createWhiteQueen());
        rank.addWhitePieces(Piece.createWhiteKing());
        rank.addWhitePieces(Piece.createWhiteBishop());
        rank.addWhitePieces(Piece.createWhiteKnight());
        rank.addWhitePieces(Piece.createWhiteRook());

        return rank;
    }

    public static Rank initializeWhitePawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addWhitePieces(Piece.createWhitePawn());
        }
        return rank;
    }

    public static Rank initializeBlackPieces() {
        Rank rank = new Rank();
        rank.addBlackPieces(Piece.createBlackRook());
        rank.addBlackPieces(Piece.createBlackKnight());
        rank.addBlackPieces(Piece.createBlackBishop());
        rank.addBlackPieces(Piece.createBlackQueen());
        rank.addBlackPieces(Piece.createBlackKing());
        rank.addBlackPieces(Piece.createBlackBishop());
        rank.addBlackPieces(Piece.createBlackKnight());
        rank.addBlackPieces(Piece.createBlackRook());

        return rank;
    }

    public static Rank initializeBlackPawns() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addBlackPieces(Piece.createBlackPawn());
        }
        return rank;
    }

    public static Rank initializeBlank() {
        Rank rank = new Rank();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            rank.addBlank(Piece.createBlank());
        }
        return rank;
    }

    public int getCountPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;

        for (Piece piece : pieces){
            if(piece.matchColorAndType(color,type)){
                countPiece += 1;
            }
        }

        return countPiece;
    }
}
