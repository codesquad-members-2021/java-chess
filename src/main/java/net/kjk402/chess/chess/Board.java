package net.kjk402.chess.chess;


import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;
import net.kjk402.chess.pieces.Position;

import static net.kjk402.chess.utils.StringUtils.NEWLINE;
import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final ArrayList<Rank> rankList = new ArrayList<>();

    public int PiecesCount() {
        return rankList.size();
    }

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

    public int countSamePiece(Color color, Type type) {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.countPiece(color, type);
        }
        return count;
    }

    private String getRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieceList()) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
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

}
