package net.kjk402.chess.chess;


import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;
import net.kjk402.chess.pieces.Position;

import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final List<Rank> rankList = new ArrayList<>();

    public void initialize() {
        rankList.add(Rank.createWhitePiecesRank(0));
        rankList.add(Rank.createWhitePawnsRank(1));
        rankList.add(Rank.creatBlankLine(2));
        rankList.add(Rank.creatBlankLine(3));
        rankList.add(Rank.creatBlankLine(4));
        rankList.add(Rank.creatBlankLine(5));
        rankList.add(Rank.createBlackPawnsRank(6));
        rankList.add(Rank.createBlackPiecesRank(7));
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            rankList.add(Rank.creatBlankLine(i));
        }
    }

    public int countSamePiece(Color color, Type type) {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.countPiece(color, type);
        }
        return count;
    }

    public String showBoard() {
        StringBuilder boardOutput = new StringBuilder();
        String rankIndex = "abcdefgh";
        for (int i = 0; i < BOARD_SIZE; i++) {
            int boardSizeMinusI = BOARD_SIZE - i;
            boardOutput.append(appendNewLine(getRepresentationByRank(rankList.get(boardSizeMinusI - 1)) + " " + (boardSizeMinusI)));
        }
        boardOutput.append(appendNewLine(rankIndex));
        return boardOutput.toString();
    }

    public Piece findPiece(String position) {
        Position tempPosition = new Position(position);
        return rankList.get(tempPosition.getFile()).getPiece(tempPosition.getRank());
    }

    public void move(String position, Piece piece) {
        Position targetPosition = new Position(position);
        rankList.get(targetPosition.getFile()).move(targetPosition.getRank(), piece);
    }

    public double caculcatePoint(Color color) {
        double pointSum = 0.0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            pointSum += getPoint(rankList.get(i), color);
        }
        return pointSum;
    }

    public String piecesSort(List<Piece> pieceList, Color color) {
        Collections.sort(pieceList);
        StringBuilder sortedPieces = new StringBuilder();
        for (Piece piece : pieceList) {
            if (piece.getColor() == color) {
                sortedPieces.append(piece.getRepresentation());
            }
        }
        return sortedPieces.toString();
    }

    private double getPoint(Rank rank, Color color) {
        double sum = 0.0;
        for (Piece piece : rank.getPieceList()) {
            if (piece.getColor() == color) {
                sum += piece.getType().getDefaultPoint();
            }
        }
        return sum;
    }

    private String getRepresentationByRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieceList()) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

}
