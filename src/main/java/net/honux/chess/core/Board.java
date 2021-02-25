package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.File;
import net.honux.chess.attribute.Type;
import net.honux.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.honux.chess.core.Rank.*;
import static net.honux.chess.util.Position.getIndex;
import static net.honux.chess.util.Position.getRank;
import static net.honux.chess.util.StringUtils.appendNewLine;
import static net.honux.chess.util.StringUtils.convertString;

public class Board {

    public static final int BOARD_SIZE = 8;
    private final List<Rank> board;

    public Board() {
        board = new ArrayList(BOARD_SIZE);
    }

    public void initialize() {
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
        return board.stream().mapToInt(rank -> rank.getPointsOfType(color)).sum() - samePlacedPawns(color);
    }

    private int countOfTeamPieces(Color color) {
        return board.stream().mapToInt(rank -> rank.countOfTeamPieces(color)).sum();
    }

    private double samePlacedPawns(Color color) {
        double exceptPoint = 0;
        double halfPoint = Type.PAWN.getPoint() / 2;
        for (Rank rank : board) {
            int countOfPawnsInSameRank = rank.countOfPieces(color, Type.PAWN);
            if (countOfPawnsInSameRank > 1) {
                exceptPoint += halfPoint * countOfPawnsInSameRank;
            }
        }
        return exceptPoint;
    }

    public int countOfPiece(Color color, Type type) {
        return board.stream().mapToInt(rank -> rank.countOfPieces(color, type)).sum();
    }

    public Optional<Piece> findPiece(String position) {
        try {
            return Optional.ofNullable(board.get(getRank(position)).get(getIndex(position)));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public String getBoardStatusToString() {
        StringBuilder sb = new StringBuilder();
        for(File f : File.values()) {
            if(File.isLast(f)){
                appendNewLine(sb, findPiece(f.name()).get().getRepresentation());
                continue;
            }
            sb.append(findPiece(f.name()).get().getRepresentation());
        }
        return convertString(sb);
    }

    public void print() {
        System.out.println(this.getBoardStatusToString());
    }

}
