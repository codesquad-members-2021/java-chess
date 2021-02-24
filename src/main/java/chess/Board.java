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

    private final List<Rank> ranks = new ArrayList<>(BOARD_SIZE);

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
        for (Rank rank : ranks) {
            countPiece += rank.getCountPieceByColorAndType(color, type);
        }

        return countPiece;
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> pieces = new ArrayList<>();

        for (Rank rank : ranks) {
            pieces.addAll(rank.findPieceByColor(color));
        }

        return pieces;
    }

    public Piece findPiece(String position) {
        Position chessBoardIndex = new Position(position);

        return ranks.get((chessBoardIndex.getFile())).getPiece(chessBoardIndex.getRank());
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
        ranks.add(Rank.initializeWhitePieces(FILE_INDEX));
        ranks.add(Rank.initializeWhitePawns(FILE_INDEX - 1));
        ranks.add(Rank.initializeBlank(FILE_INDEX - 2));
        ranks.add(Rank.initializeBlank(FILE_INDEX - 3));
        ranks.add(Rank.initializeBlank(FILE_INDEX - 4));
        ranks.add(Rank.initializeBlank(FILE_INDEX - 5));
        ranks.add(Rank.initializeBlackPawns(FILE_INDEX - 6));
        ranks.add(Rank.initializeBlackPieces(FILE_INDEX - 7));
    }

    public void initializeAllEmpty() {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            ranks.add(Rank.initializeBlank(i));
        }
    }

    public void move(String position, Piece piece) {
        Position chessBoardIndex = new Position(position);

        ranks.get(chessBoardIndex.getFile()).move(chessBoardIndex.getRank(), piece);
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
            boardRank.append(getRank(ranks.get(fileIndex)));
            boardRank.append(" ").append(fileIndex + 1);
            boardRank.append(StringUtils.getNewLine());
        }

        boardRank.append(StringUtils.getNewLine());
        boardRank.append(StringUtils.addNewLine(rankIndex));
        return boardRank.toString();
    }
}