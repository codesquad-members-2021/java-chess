package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

import static net.eno.utils.StringUtils.appendNewLine;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Board {

    private List<Rank> board;

    public Board() {
        this.board = new ArrayList<>();
    }

    private void addRank(Rank rank) {
        this.board.add(rank);
    }

    public int countTargetPiece(Color color, PieceType pieceType) {
        int count = 0;
        for (Rank rank : this.board) {
            count += rank.countTargetPiece(color, pieceType);
        }
        return count;
    }

    public Piece findPiece(String position) {
        Position positionObj = new Position(position);
        Rank targetRank = this.board.get(positionObj.getRankIndex());
        return targetRank.findPiece(positionObj.getFileIndex());
    }

    public void move(String position, Piece piece) {
        Position positionObj = new Position(position);
        Rank targetRank = this.board.get(positionObj.getRankIndex());
        targetRank.move(positionObj.getFileIndex(), piece);
    }

    public double calculatePoint(Color color) {
        double point = 0;
        for (Rank rank : this.board) {
            point += rank.calculateRankPoint(color);
        }

        double pawnNumber = 0;
        for (char file = 'a'; file <= 'h'; file++) {
            pawnNumber += countSameFilePawn(file, color);
        }

        return point - (pawnNumber / 2);
    }

    private int countSameFilePawn(char file, Color color) {
        int count = 0;
        for (int rank = 1; rank <= 8; rank++) {
            Piece piece = findPiece(String.valueOf(file) + rank);
            if (piece.getColor() == color &&
                    piece.getPieceType() == PieceType.PAWN) {
                count++;
            }
        }
        return count > 1 ? count : 0;
    }

    public List<Piece> sortByPiecePoint(Color color, boolean isAscending) {
        List<Piece> pieceList = new ArrayList<>();
        for (Rank rank : this.board) {
            pieceList.addAll(rank.getPieceListByColor(color));
        }
        if (isAscending) {
            Collections.sort(pieceList);
        } else {
            pieceList.sort(Collections.reverseOrder());
        }
        return pieceList;
    }

    public void initialize() {
        this.board = new ArrayList<>();
        addRank(Rank.createMultiplePieceRank(Color.BLACK));
        addRank(Rank.createOnePieceRank(Color.BLACK, PieceType.PAWN));
        addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(Color.WHITE, PieceType.PAWN));
        addRank(Rank.createMultiplePieceRank(Color.WHITE));
    }

    public void initializeEmpty() {
        this.board = new ArrayList<>();
        for (int rank = 0; rank < 8; rank++) {
            addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        }
    }

    public String showBoard(Color color) {
        StringBuilder result = new StringBuilder();
        int reverseRank = color == Color.BLACK ? 7 : 0;
        for (int rankNum = 0; rankNum < this.board.size(); rankNum++) {
            Rank rank = board.get(Math.abs(rankNum - reverseRank));
            result.append(appendNewLine(rank.showRank(color)));
        }
        return result.toString();
    }

}
