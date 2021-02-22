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

    public Piece findPiece(String s) {
        char rankIndex = s.charAt(0);
        char fileIndex = s.charAt(1);

        int rankIndexPos = rankIndex - 'a';
        int fileIndexPos = Character.getNumericValue(fileIndex);

        return files.get((fileIndexPos-1)).getPiece(rankIndexPos);
    }

    private String getRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : rank.getPieces()){
            if(piece.isBlack()){
                sb.append(piece.getType().getBlackRepresentation()).append(" ");
            } else {
                sb.append(piece.getType().getWhiteRepresentation()).append(" ");
            }

        }
        return sb.toString();
    }

    public void initialize() {
        files.add(Rank.initializeWhitePieces());
        files.add(Rank.initializeWhitePawns());
        files.add(Rank.initializeBlank());
        files.add(Rank.initializeBlank());
        files.add(Rank.initializeBlank());
        files.add(Rank.initializeBlank());
        files.add(Rank.initializeBlackPawns());
        files.add(Rank.initializeBlackPieces());
    }
}