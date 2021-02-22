package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Type;
import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.Optional;

import static net.honux.chess.core.Rank.*;
import static net.honux.chess.util.Position.getIndex;
import static net.honux.chess.util.Position.getRank;
import static net.honux.chess.util.StringUtils.appendNewLine;
import static net.honux.chess.util.StringUtils.convertString;

public class Board {

    public static final int BOARD_SIZE = 8;
    private ArrayList<Rank> board;

    public void initialize() {
        board = new ArrayList(BOARD_SIZE);
        board.add(createARank());
        board.add(createBRank());
        board.add(createCRank());
        board.add(createDRank());
        board.add(createERank());
        board.add(createFRank());
        board.add(createGRank());
        board.add(createHRank());
    }

    public void initializeEmpty() {
        board = new ArrayList(BOARD_SIZE);
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(createBlankPieces());
        }
    }

    public void move(String position, Piece piece) {
        board.get(getRank(position)).putPiece(getIndex(position), piece);
    }

    public int blackPiecesCount() {
        return countOfTeamPieces(Color.BLACK);
    }

    public int whitePiecesCount() {
        return countOfTeamPieces(Color.WHITE);
    }

    public double blackTeamPoint() {
        return getTeamPoints(Color.BLACK);
    }

    public double whiteTeamPoint() {
        return getTeamPoints(Color.WHITE);
    }

    private double getTeamPoints(Color color) {
        int teamPoint = 0;
        for (Rank rank : board) {
            teamPoint += rank.getPointsOfType(color);
        }
        return teamPoint - samePlacedPawns(color);
    }

    private int countOfTeamPieces(Color color) {
        int countOfTeamPieces = 0;
        for (Rank RANK : board) {
            countOfTeamPieces += RANK.countOfTeamPieces(color);
        }
        return countOfTeamPieces;
    }

    private double samePlacedPawns(Color color) {
        double exceptPoint = 0;
        double halfPoint = Type.PAWN.getPoint() / 2;
        for (Rank rank : board) {
            int countOfPawnsInSameRank = rank.countOfPiece(color, Type.PAWN);
            if (countOfPawnsInSameRank > 1) {
                exceptPoint += halfPoint * countOfPawnsInSameRank;
            }
        }
        return exceptPoint;
    }

    public int countOfPiece(Color color, Type type) {
        int countOfBlackPawns = 0;
        for (Rank rank : board) {
            countOfBlackPawns += rank.countOfPiece(color, type);
        }
        return countOfBlackPawns;
    }

    public Optional<Piece> findPiece(String position) {
        Optional<Piece> piece = Optional.empty();
        try {
            piece = Optional.ofNullable(board.get(getRank(position)).get(getIndex(position)));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
        return piece;
    }

    public String getBoardStatusToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                sb.append(board.get(j).get(i).toString());
            }
            appendNewLine(sb, "");
        }
        return convertString(sb);
    }

    public void print() {
        System.out.println(this.getBoardStatusToString());
    }

}
