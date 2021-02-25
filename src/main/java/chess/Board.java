package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chess.pieces.Piece.*;
import static chess.pieces.Piece.Type.*;
import static chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int MAX_RANK = 8;
    public static final int MAX_FILE = 8;
    public static final int RANK_1 = 0;
    public static final int RANK_2 = 1;
    public static final int RANK_3 = 2;
    public static final int RANK_4 = 3;
    public static final int RANK_5 = 4;
    public static final int RANK_6 = 5;
    public static final int RANK_7 = 6;
    public static final int RANK_8 = 7;
    public static final int FILE_A = 0;
    public static final int FILE_B = 1;
    public static final int FILE_C = 2;
    public static final int FILE_D = 3;
    public static final int FILE_E = 4;
    public static final int FILE_F = 5;
    public static final int FILE_G = 6;
    public static final int FILE_H = 7;


    List<Rank> board = new ArrayList<>();

    Board() {
        for (int i = 0; i < MAX_RANK; i++) {
            board.add(new Rank());
        }
    }

    public int pieceCount() {
        return board.get(RANK_1).size()
                + board.get(RANK_2).size()
                + board.get(RANK_7).size()
                + board.get(RANK_8).size();
    }

    public int pieceCountOf(Color color, Type type) {
        int pieceCount = 0;
        for (int rank = 0; rank < MAX_RANK; rank++) {
            pieceCount += board.get(rank).pieceCountOf(color, type);

        }
        return pieceCount;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        Piece target = board.get(pos.rank()).getPieceOf(pos.file());
        return target;
    }

    public void move(Piece piece) {
        Position position = piece.getPosition();
        board.get(position.rank()).set(position.file(), piece);
    }

    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        addBlank();
        addWhitePawns();
        addWhitePieces();
    }

    public void initializeEmpty() {
        for (int rank = RANK_1; rank < MAX_RANK; rank++) {
            board.set(rank, getBlankRank(rank));
        }
    }

    private Rank getBlankRank(int rank) {
        Rank blankRank = new Rank();
        for (int file = FILE_A; file < MAX_FILE; file++) {
            blankRank.add(Piece.createBlank(new Position(file, rank)));
        }
        return blankRank;
    }

    private void addBlackPieces() {
        board.get(RANK_8).addAll(Arrays.asList(
                Piece.createBlack(ROOK, new Position(FILE_A, RANK_8))
                , Piece.createBlack(KNIGHT, new Position(FILE_B, RANK_8))
                , Piece.createBlack(BISHOP, new Position(FILE_C, RANK_8))
                , Piece.createBlack(QUEEN, new Position(FILE_D, RANK_8))
                , Piece.createBlack(KING, new Position(FILE_E, RANK_8))
                , Piece.createBlack(BISHOP, new Position(FILE_F, RANK_8))
                , Piece.createBlack(KNIGHT, new Position(FILE_G, RANK_8))
                , Piece.createBlack(ROOK, new Position(FILE_H, RANK_8)))
        );
    }

    private void addBlackPawns() {
        for (int file = FILE_A; file < MAX_FILE; file++) {
            board.get(RANK_7).add(Piece.createBlack(PAWN, new Position(file, RANK_7)));
        }
    }

    private void addBlank() {
        for (int file = FILE_A; file < MAX_FILE; file++) {
            board.get(RANK_6).add(Piece.createBlank(new Position(file, RANK_6)));
            board.get(RANK_5).add(Piece.createBlank(new Position(file, RANK_5)));
            board.get(RANK_4).add(Piece.createBlank(new Position(file, RANK_4)));
            board.get(RANK_3).add(Piece.createBlank(new Position(file, RANK_3)));
        }
    }

    private void addWhitePawns() {
        for (int file = FILE_A; file < MAX_FILE; file++) {
            board.get(RANK_2).add(Piece.createWhite(PAWN, new Position(file, RANK_2)));
        }
    }

    private void addWhitePieces() {
        board.get(RANK_1).addAll(Arrays.asList(
                Piece.createWhite(ROOK, new Position(FILE_A, RANK_1))
                , Piece.createWhite(KNIGHT, new Position(FILE_B, RANK_1))
                , Piece.createWhite(BISHOP, new Position(FILE_C, RANK_1))
                , Piece.createWhite(QUEEN, new Position(FILE_D, RANK_1))
                , Piece.createWhite(KING, new Position(FILE_E, RANK_1))
                , Piece.createWhite(BISHOP, new Position(FILE_F, RANK_1))
                , Piece.createWhite(KNIGHT, new Position(FILE_G, RANK_1))
                , Piece.createWhite(ROOK, new Position(FILE_H, RANK_1)))
        );
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();

        chessBoard.append(appendNewLine(getRankResult(board.get(RANK_8)) + "  8 (rank 8)"))
                .append(appendNewLine(getRankResult(board.get(RANK_7)) + "  7"))
                .append(appendNewLine(getRankResult(board.get(RANK_6)) + "  6"))
                .append(appendNewLine(getRankResult(board.get(RANK_5)) + "  5"))
                .append(appendNewLine(getRankResult(board.get(RANK_4)) + "  4"))
                .append(appendNewLine(getRankResult(board.get(RANK_3)) + "  3"))
                .append(appendNewLine(getRankResult(board.get(RANK_2)) + "  2"))
                .append(appendNewLine(getRankResult(board.get(RANK_1)) + "  1 (rank 1)"))
                .append(appendNewLine(" "))
                .append("abcdefgh");

        return chessBoard.toString();
    }

    private String getRankResult(Rank rank) {
        StringBuilder rankResult = new StringBuilder();
        rank.pieces().forEach(piece ->
                rankResult.append(piece.getType().getRepresentationWith(piece.getColor())));
        return rankResult.toString();
    }

    public double calculateScoreOf(Color color) {
        List<Piece> remainedPieces = getRemainedPiecesInOrder(color);
        double score = remainedPieces.stream()
                .mapToDouble(piece -> piece.getPoint(remainedPieces))
                .sum();
        return score;
    }

    public List<Piece> getRemainedPiecesInOrder(Color color) {
        List<Piece> remainedPiecesOfColor = board.stream()
                .flatMap(rank -> rank.getPiecesOf(color).stream())
                .sorted()
                .collect(Collectors.toList());
        return remainedPiecesOfColor;
    }

}
