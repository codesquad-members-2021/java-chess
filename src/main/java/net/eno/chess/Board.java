package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

import static net.eno.utils.StringUtils.appendNewLine;

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

    public int pieceCount() {
        int count = 0;
        for (Rank rank : this.board) {
            count += rank.pieceCount();
        }
        return count;
    }

    public int targetPieceCount(Color color, PieceType pieceType) {
        int count = 0;
        for (Rank rank : this.board) {
            count += rank.targetPieceCount(color, pieceType);
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
        double result = 0;
        for (int rank = 8; rank > 0; rank--) {
            for (char file = 'a'; file < 'i'; file++) {
                Piece piece = findPiece(String.valueOf(file) + rank);
                if (piece.getColor().equals(color)) {
                    result += piece.getPieceType().getDefaultPoint();
                }
            }
        }
        return result;
    }

    public void initialize() {
        this.board = new ArrayList<>();
        addRank(Rank.createMultiplePieceRank(8, Color.BLACK));
        addRank(Rank.createOnePieceRank(7, Color.BLACK, PieceType.PAWN));
        addRank(Rank.createOnePieceRank(6, Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(5, Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(4, Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(3, Color.NOCOLOR, PieceType.NO_PIECE));
        addRank(Rank.createOnePieceRank(2, Color.WHITE, PieceType.PAWN));
        addRank(Rank.createMultiplePieceRank(1, Color.WHITE));
    }

    public void initializeEmpty() {
        this.board = new ArrayList<>();
        for (int rankNumber = 8; rankNumber > 0; rankNumber--) {
            addRank(Rank.createOnePieceRank(rankNumber, Color.NOCOLOR, PieceType.NO_PIECE));
        }
    }

    public String showBoard(Color color) {
        StringBuilder result = new StringBuilder();
        int reverseRank = color.equals(Color.BLACK) ? 7 : 0;
        for (int rankNumber = 0; rankNumber < this.board.size(); rankNumber++) {
            Rank rank = board.get(Math.abs(rankNumber - reverseRank));
            result.append(appendNewLine(rank.showRank(color)));
        }
        return result.toString();
    }

}
