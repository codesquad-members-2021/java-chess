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
        return countAllPiecesByColor(Color.WHITE) + countAllPiecesByColor(Color.BLACK);
    }

    public int countAllPiecesByColor(Color color){
        int count = 0;
        count += countPieceByColorAndType(color, Type.PAWN);
        count += countPieceByColorAndType(color, Type.ROOK);
        count += countPieceByColorAndType(color, Type.KNIGHT);
        count += countPieceByColorAndType(color, Type.BISHOP);
        count += countPieceByColorAndType(color, Type.QUEEN);
        count += countPieceByColorAndType(color, Type.KING);
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
        final int FILE_INDEX = 8;
        files.add(Rank.initializeWhitePieces(FILE_INDEX));
        files.add(Rank.initializeWhitePawns(FILE_INDEX - 1));
        files.add(Rank.initializeBlank(FILE_INDEX - 2));
        files.add(Rank.initializeBlank(FILE_INDEX - 3));
        files.add(Rank.initializeBlank(FILE_INDEX - 4));
        files.add(Rank.initializeBlank(FILE_INDEX - 5));
        files.add(Rank.initializeBlackPawns(FILE_INDEX - 6));
        files.add(Rank.initializeBlackPieces(FILE_INDEX - 7));
    }

    public void initializeAllEmpty() {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            files.add(Rank.initializeBlank(i));
        }
    }

    public void move(String position, Piece piece) {
        Position chessBoardIndex = new Position(position);

        files.get(chessBoardIndex.getFile()).move(chessBoardIndex.getRank(), piece);
        piece.setPosition(chessBoardIndex);
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

        String rankIndex = "a b c d e f g h";

        for (int fileIndex = BOARD_SIZE - 1; fileIndex >= 0; fileIndex--) {
            boardRank.append(getRank(files.get(fileIndex)));
            boardRank.append(" ").append(fileIndex + 1);
            boardRank.append(StringUtils.getNewLine());
        }

        boardRank.append(StringUtils.getNewLine());
        boardRank.append(StringUtils.addNewLine(rankIndex));
        return boardRank.toString();
    }
}