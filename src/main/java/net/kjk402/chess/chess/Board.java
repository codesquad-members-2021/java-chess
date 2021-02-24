package net.kjk402.chess.chess;


import net.kjk402.chess.pieces.Piece;
import net.kjk402.chess.pieces.Piece.*;

import static net.kjk402.chess.utils.StringUtils.NEWLINE;
import static net.kjk402.chess.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Rank> rankList = new ArrayList<>(BOARD_SIZE);

    public int PiecesCount() {
        return rankList.size();
    }

    public void initalize() {
        Rank rank = new Rank();
        rankList.add(rank.setBlackPieces(0));
        rankList.add(rank.setBlackPawns(1));
        rankList.add(rank.setBlackLine(2));
        rankList.add(rank.setBlackLine(3));
        rankList.add(rank.setBlackLine(4));
        rankList.add(rank.setBlackLine(5));
        rankList.add(rank.setWhitePawns(6));
        rankList.add(rank.setWhitePieces(7));
    }

    public int countSamePiece(Color color, Type type) {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.countPiece(color, type);
        }
        return count;
    }

    private String getRank(Rank rank, int index) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieceList()) {
            if (piece.getPosition().getRank() == index) {
                sb.append(piece.getRepresentation());
            }
        }
        return sb.toString();
    }

    public String showBoard() {
        StringBuilder boardOutput = new StringBuilder();
        String rankIndex = "abcdefgh";
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_SIZE; i++) {
            boardOutput.append(appendNewLine(getRank(rank, i) + " " + (BOARD_SIZE - i)));
        }
        boardOutput.append(appendNewLine(rankIndex));
        return boardOutput.toString();
    }

}
