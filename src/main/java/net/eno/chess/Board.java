package net.eno.chess;

import net.eno.pieces.Piece;
import net.eno.pieces.PieceType;
import net.eno.pieces.Position;

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
        Position position = new Position(location);
        int file = position.getFile();
        int rank = position.getRank();
        Rank targetRank = this.board.get(rank);
        return targetRank.findPiece(file);
    }

    public void move(String location, Piece piece) {
        Position position = new Position(location);
        int file = position.getFile();
        int rank = position.getRank();
        Rank targetRank = this.board.get(rank);
        targetRank.move(file, piece);
    }

    public void initialize() {
        this.board = new ArrayList<>();
        addRank(Rank.createBlackPieces());
        addRank(Rank.createBlackPawns());
        addRank(Rank.createBlankLine(6));
        addRank(Rank.createBlankLine(5));
        addRank(Rank.createBlankLine(4));
        addRank(Rank.createBlankLine(3));
        addRank(Rank.createWhitePawns());
        addRank(Rank.createWhitePieces());
    }

    public void initializeEmpty() {
        this.board = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            addRank(Rank.createBlankLine(8 - i));
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
