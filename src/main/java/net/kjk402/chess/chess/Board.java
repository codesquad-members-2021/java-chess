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
    private final ArrayList<Rank> rankList = new ArrayList<>();

    public void initialize() {
        rankList.add(Rank.setWhitePieces(0));
        rankList.add(Rank.setWhitePawns(1));
        rankList.add(Rank.setBlackLine(2));
        rankList.add(Rank.setBlackLine(3));
        rankList.add(Rank.setBlackLine(4));
        rankList.add(Rank.setBlackLine(5));
        rankList.add(Rank.setBlackPawns(6));
        rankList.add(Rank.setBlackPieces(7));
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            rankList.add(Rank.setBlackLine(i));
        }
    }

    public String showBoard() {
        StringBuilder boardOutput = new StringBuilder();
        String rankIndex = "abcdefgh";
        for (int i = 0; i < BOARD_SIZE; i++) {
            boardOutput.append(appendNewLine(getRank(rankList.get(BOARD_SIZE - 1 - i)) + " " + (BOARD_SIZE - i)));
        }
        boardOutput.append(appendNewLine(rankIndex));
        return boardOutput.toString();
    }

    public Piece findPiece(String position) {
        Position tempPosition = new Position(position);
        return rankList.get((tempPosition.getFile())).getPiece(tempPosition.getRank());
    }

    public void move(String position, Piece piece) {
        Position tempPosition = new Position(position);
        rankList.get(tempPosition.getFile()).move(tempPosition.getRank(), piece);
        Rank rank = new Rank();
        rank.addPiece(piece);
    }

    public double caculcatePoint(Color color) {
        double pointSum = 0.0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            pointSum += getPoint(rankList.get(i), color);
        }
        return pointSum;
    }

    public String piecesSort(List<Piece> list, Color color) {
        Collections.sort(list);
        StringBuilder sortedPieces = new StringBuilder();
        for (Piece piece : list) {
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

    private String getRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieceList()) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

}
