package net.coco.chess;

import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;
import net.coco.pieces.Point;
import net.coco.valid.PieceValid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Rank> ranks = new ArrayList<>();
    public static final int BOARD_CELLS = 8;

    public void initializeWithPieces() {
        //rank1이 화이트쪽이라 먼저 쌓인다.
        ranks.clear();
        ranks.add(Rank.initWhitePieces());
        ranks.add(Rank.initWhitePawns());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlankLine());
        ranks.add(Rank.initBlackPawns());
        ranks.add(Rank.initBlackPieces());
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_CELLS; i++) {
            ranks.add(Rank.initBlankLine());
        }
    }

    public int getPieceCount(String color, PieceType pieceType) {
        PieceValid.checkColorType(color);
        int count = 0;
        for (Rank rank : ranks) {
            count += rank.findPieceCount(pieceType.getRepresentation(color));
        }
        return count;
    }

    public Piece getPieceFromPoint(String pointStr) {
        Point point = new Point(pointStr);
        return ranks.get(point.getColumn()).findPieceFromPoint(point.getRow());
    }

    public String getRankResult(int findRank) {
        return getPiecesToString(ranks.get(findRank).getPieces());
    }


    private String getPiecesToString(List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> String.valueOf(piece.getRepresentation()))
                .collect(Collectors.joining());
    }

    public void move(String pointStr, Piece piece) {
        Point point = new Point(pointStr);

        ranks.get(point.getColumn()).movePieceToPoint(piece, point.getRow());
    }

    public double calculateScore(String color) {
        PieceValid.checkColorType(color);
        double sum = getSum(color);
        return sum;
    }

    private double getSum(String color) {
        double sum = 0.0;
        for (int column = 0; column < ranks.size(); column++) {
            int pawnCount = 0;
            List<Piece> pieces = getPieces(color, column);

            for (Piece piece : pieces) {
                pawnCount += piece.getPieceType() == PieceType.PAWN ? 1 : 0;
                sum += piece.getScore();
            }
            sum -= pawnCount * 0.5;
        }
        return sum;
    }

    private List<Piece> getPieces(String color, int column) {
        ArrayList<Piece> getPieces = new ArrayList<>();
        for (int row = 0; row < ranks.size(); row++) {
            Rank getRank = ranks.get(row);
            getPieces.add(getRank.findPiece(color, column));
        }
        return getPieces;
    }
}
