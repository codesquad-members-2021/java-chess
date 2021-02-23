package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;

import static net.eno.utils.StringUtils.appendNewLine;

import java.security.InvalidParameterException;
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

    public int targetPieceCount(PieceType pieceType) {
        int count = 0;
        for (Rank rank : this.board) {
            count += rank.targetPieceCount(pieceType);
        }
        return count;
    }

    public Piece findPiece(String location) {
        int[] parseLocation = parseLocation(location);
        if (parseLocation[0] == 0) {
            return Piece.createPiece(PieceType.NO_PIECE);
        }
        Rank targetRank = this.board.get(8 - parseLocation[1]);
        return targetRank.findPiece(parseLocation[0]);
    }

    public void move(String location, Piece piece) {
        int[] parseLocation = parseLocation(location);
        if (parseLocation[0] != 0) {
            Rank targetRank = this.board.get(8 - parseLocation[1]);
            targetRank.move(parseLocation[0], piece);
        }
    }

    private int[] parseLocation(String location) {
        int[] splitLocation = new int[2];

        try {
            int file = location.charAt(0);
            int rank = Character.getNumericValue(location.charAt(1));
            if (location.length() == 2 &&
                97 <= file && file <= 104 &&
                1 <= rank && rank <= 8) {
                splitLocation[0] = file;
                splitLocation[1] = rank;
            } else {
                System.out.println("location range error");
            }
        } catch (Exception e) {
            System.out.println("location parsing error");
        }

        return splitLocation;
    }

    public void initialize() {
        this.board = new ArrayList<>();
        addRank(Rank.createBlackPieces());
        addRank(Rank.createBlackPawns());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createWhitePawns());
        addRank(Rank.createWhitePieces());
    }

    public void initializeEmpty() {
        this.board = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            addRank(Rank.createBlankLine());
        }
    }

    public String showBoard(String color) {
        StringBuilder result = new StringBuilder();
        int num = reverseOrder(color);
        for (int i = 0; i < this.board.size(); i++) {
            Rank rank = board.get(Math.abs(i - num));
            result.append(appendNewLine(rank.getPiecesResult(num)));
        }
        return result.toString();
    }

    private int reverseOrder(String color) {
        if (color.equals("white")) {
            return 0;
        } else if (color.equals("black")) {
            return 7;
        }
        throw new InvalidParameterException("Color error");
    }

}
