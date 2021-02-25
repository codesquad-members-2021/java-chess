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
        return countingAllPiecesByColor(Color.WHITE) + countingAllPiecesByColor(Color.BLACK);
    }

    public int countingAllPiecesByColor(Color color) {
        int count = 0;

        for (Type type : Type.values()) {
            count += countPiecesByColorAndType(color, type);
        }

        return count;
    }

    public int countPiecesByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.getCountPiecesByColorAndType(color, type);
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
        Position positionNumber = new Position(position);

        return ranks.get(positionNumber.getFile()).getPiece(positionNumber.getRank());
    }

    private String getRank(Rank rank) {
        StringBuilder sb = new StringBuilder();
        for (Piece piece : rank.getRank()) {
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

    public void initializeEmpty() {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            ranks.add(Rank.initializeBlank(i));
        }
    }

    public void move(String position, Piece piece) {
        Position chessBoardIndex = new Position(position);

        ranks.get(chessBoardIndex.getFile()).move(chessBoardIndex.getRank(), piece);
        piece.setPosition(chessBoardIndex);
    }

    public double calculatePointByColor(Color color) {
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