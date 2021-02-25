package net.eno.chess;

import net.eno.pieces.Color;
import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

import static net.eno.utils.StringUtils.NEWLINE;
import static net.eno.utils.StringUtils.appendNewLine;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Board {

    private List<Rank> board;

    public Board() {
        this.board = new ArrayList<>();
    }

    private void addRank(Rank rank) {
        this.board.add(rank);
    }

    public int countTargetPiece(Color color, PieceType pieceType) {
        return this.board.stream()
                .mapToInt(rank -> rank.countTargetPiece(color, pieceType))
                .sum();
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
        double point = this.board.stream()
                .mapToDouble(rank -> rank.calculateRankPoint(color))
                .sum();
        double pawnNumber = IntStream.rangeClosed('a', 'h')
                .mapToDouble(file -> countSameFilePawn((char)file, color))
                .sum();
        return point - (pawnNumber / 2);
    }

    private int countSameFilePawn(char file, Color color) {
        int count = (int)IntStream.rangeClosed(1, 8)
                .mapToObj(rank -> findPiece(String.valueOf(file) + rank))
                .filter(piece -> piece.getColor() == color && piece.getPieceType() == PieceType.PAWN)
                .count();
        return count > 1 ? count : 0;
    }

    public List<Piece> sortByPiecePoint(Color color, boolean isAscending) {
        List<Piece> pieceList = this.board.stream()
                .map(rank -> rank.getPieceListByColor(color))
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
        if (!isAscending) {
            Collections.reverse(pieceList);
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
        for (int i = 0; i < 8; i++) {
            addRank(Rank.createOnePieceRank(Color.NOCOLOR, PieceType.NO_PIECE));
        }
    }

    public String showBoard(Color color) {
        String result = this.board.stream()
                .map(rank -> appendNewLine(rank.showRank()))
                .collect(Collectors.joining());
        return color != Color.BLACK ? result : new StringBuilder(result).reverse().substring(1) + NEWLINE;
    }

}
