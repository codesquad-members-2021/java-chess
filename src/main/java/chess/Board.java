package chess;

import chess.pieces.Color;
import chess.pieces.Piece;
import chess.pieces.Position;
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

    public int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : files) {
            countPiece += rank.getCountPieceByColorAndType(color, type);
        }

        return countPiece;
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();

        for (Rank rank : files) {
            pieces.addAll(rank.findPieceByColor(color));
        }

        return pieces;
    }

    public Piece findPiece(String position) {
        Position chessBoardIndex = new Position(position);

        return files.get((chessBoardIndex.getFile())).getPiece(chessBoardIndex.getRank());
    }

    private String getRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            if (piece.isBlack()) {
                sb.append(piece.getType().getBlackRepresentation()).append(" ");
            } else {
                sb.append(piece.getType().getWhiteRepresentation()).append(" ");
            }

        }
        return sb.toString();
    }

    public void initialize() {
        files.add(Rank.initializeWhitePieces(8));
        files.add(Rank.initializeWhitePawns(7));
        files.add(Rank.initializeBlank(6));
        files.add(Rank.initializeBlank(5));
        files.add(Rank.initializeBlank(4));
        files.add(Rank.initializeBlank(3));
        files.add(Rank.initializeBlackPawns(2));
        files.add(Rank.initializeBlackPieces(1));
    }

    public void initializeAllEmpty() {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            files.add(Rank.initializeBlank(i));
        }
    }

    public void move(String position, Piece piece) {
        Position chessBoardIndex = new Position(position);

        files.get(chessBoardIndex.getFile()).move(chessBoardIndex.getRank(), piece);
    }

    public double totalCalculatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint(pieces);
        }

        return point;
    }

    public String getChessBoard() {
        StringBuilder boardRank = new StringBuilder();

        String fileIndex = "a b c d e f g h";

        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            boardRank.append(getRank(files.get(i)));
            boardRank.append(" ").append(i + 1);
            boardRank.append(StringUtils.getNewLine());
        }

        boardRank.append(StringUtils.getNewLine());
        boardRank.append(StringUtils.addNewLine(fileIndex));
        return boardRank.toString();
    }
}