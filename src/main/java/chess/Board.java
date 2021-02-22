package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Type;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 8;

    private final List<Rank> files = new ArrayList<>(BOARD_SIZE);

    public int totalPiecesCount() {
        int count = 0;

        count += countPieceByColorAndType(Color.WHITE, Type.PAWN);
        count += countPieceByColorAndType(Color.WHITE, Type.ROOK);
        count += countPieceByColorAndType(Color.WHITE, Type.KNIGHT);
        count += countPieceByColorAndType(Color.WHITE, Type.BISHOP);
        count += countPieceByColorAndType(Color.WHITE, Type.QUEEN);
        count += countPieceByColorAndType(Color.WHITE, Type.KING);

        count += countPieceByColorAndType(Color.BLACK, Type.PAWN);
        count += countPieceByColorAndType(Color.BLACK, Type.ROOK);
        count += countPieceByColorAndType(Color.BLACK, Type.KNIGHT);
        count += countPieceByColorAndType(Color.BLACK, Type.BISHOP);
        count += countPieceByColorAndType(Color.BLACK, Type.QUEEN);
        count += countPieceByColorAndType(Color.BLACK, Type.KING);

        return count;
    }

    public int countPieceByColorAndType(Color color, Type type){
        int countPiece = 0;
        for(Rank rank : files) {
            countPiece += rank.getCountPieceByColorAndType(color, type);
        }

        return countPiece;
    }

}