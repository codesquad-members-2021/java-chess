package net.eno.chess;

import net.eno.pieces.PieceType;

import static net.eno.utils.StringUtils.appendNewLine;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;


public class Board {

    private final List<Rank> board;

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

    public void initialize() {
        addRank(Rank.createBlackPieces());
        addRank(Rank.createBlackPawns());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createBlankLine());
        addRank(Rank.createWhitePawns());
        addRank(Rank.createWhitePieces());
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
