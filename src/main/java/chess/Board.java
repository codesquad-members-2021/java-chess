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
    public static final int RANK1 = 0;
    public static final int RANK2 = 1;
    public static final int RANK3 = 2;
    public static final int RANK4 = 3;
    public static final int RANK5 = 4;
    public static final int RANK6 = 5;
    public static final int RANK7 = 6;
    public static final int RANK8 = 7;

    List<Rank> board = new ArrayList<>();

    Board() {
        for (int i = 0; i < MAX_RANK; i++) {
            board.add(new Rank());
        }
    }

    public int pieceCount() {
        return board.get(RANK1).size()
                + board.get(RANK2).size()
                + board.get(RANK7).size()
                + board.get(RANK8).size();
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

    public void putPieceIn(String position, Piece piece) {
        Position pos = new Position(position);
        board.get(pos.rank()).set(pos.file(), piece);
    }

    public void initialize() {
        addBlackPieces();
        addBlackPawns();
        addBlank();
        addWhitePawns();
        addWhitePieces();
    }

    public void initializeEmpty() {
        for (int rank = 0; rank < MAX_RANK; rank++) {
            board.set(rank, getBlankRank());
        }
    }

    private Rank getBlankRank() {
        Rank rank = new Rank();
        for (int i = 0; i < MAX_FILE; i++) {
            rank.add(Piece.createBlank());
        }
        return rank;
    }

    private void addBlackPieces() {
        board.get(RANK8).addAll(Arrays.asList(
                Piece.createBlack(ROOK)
                , Piece.createBlack(KNIGHT)
                , Piece.createBlack(BISHOP)
                , Piece.createBlack(QUEEN)
                , Piece.createBlack(KING)
                , Piece.createBlack(BISHOP)
                , Piece.createBlack(KNIGHT)
                , Piece.createBlack(ROOK))
        );
    }

    private void addBlackPawns() {
        for (int i = 0; i < MAX_FILE; i++) {
            board.get(RANK7).add(Piece.createBlack(PAWN));
        }
    }

    private void addBlank() {
        for (int i = 0; i < MAX_FILE; i++) {
            board.get(RANK6).add(Piece.createBlank());
            board.get(RANK5).add(Piece.createBlank());
            board.get(RANK4).add(Piece.createBlank());
            board.get(RANK3).add(Piece.createBlank());
        }
    }

    private void addWhitePawns() {
        for (int i = 0; i < MAX_FILE; i++) {
            board.get(RANK2).add(Piece.createWhite(PAWN));
        }
    }

    private void addWhitePieces() {
        board.get(RANK1).addAll(Arrays.asList(
                Piece.createWhite(ROOK)
                , Piece.createWhite(KNIGHT)
                , Piece.createWhite(BISHOP)
                , Piece.createWhite(QUEEN)
                , Piece.createWhite(KING)
                , Piece.createWhite(BISHOP)
                , Piece.createWhite(KNIGHT)
                , Piece.createWhite(ROOK))
        );
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();

        chessBoard.append(appendNewLine(getRankResult(board.get(RANK8)) + "  8 (rank 8)"))
                .append(appendNewLine(getRankResult(board.get(RANK7)) + "  7"))
                .append(appendNewLine(getRankResult(board.get(RANK6)) + "  6"))
                .append(appendNewLine(getRankResult(board.get(RANK5)) + "  5"))
                .append(appendNewLine(getRankResult(board.get(RANK4)) + "  4"))
                .append(appendNewLine(getRankResult(board.get(RANK3)) + "  3"))
                .append(appendNewLine(getRankResult(board.get(RANK2)) + "  2"))
                .append(appendNewLine(getRankResult(board.get(RANK1)) + "  1 (rank 1)"))
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
        double score = 0.0;

        for (int rank = 0; rank < MAX_RANK; rank++) {
            int doublePawn = 0;
            Rank targetRank = board.get(rank);
            double targetRankScore = targetRank.getScoreOf(color);
            score += targetRankScore;

            if (rank == RANK1) {
                continue;
            }

            Rank beforeRank = board.get(rank - 1);
            List<Integer> targetRankFilesOfPawns = targetRank.getFilesOfPawns(color);
            List<Integer> beforeRankFilesOfPawns = beforeRank.getFilesOfPawns(color);

            for (int targetRankIndex = 0; targetRankIndex < targetRankFilesOfPawns.size(); targetRankIndex++) {
                for (int beforeRankIndex = 0; beforeRankIndex < beforeRankFilesOfPawns.size(); beforeRankIndex++) {
                    if (targetRankFilesOfPawns.get(targetRankIndex) == beforeRankFilesOfPawns.get(beforeRankIndex)) {
                        doublePawn++;
                        break;
                    }
                }
            }
            if (rank == RANK2 && doublePawn > 0) {
                score -= (doublePawn * 0.5);
            }
            if (rank == RANK8 && doublePawn > 0) {
                score -= (doublePawn * 0.5);
                break;
            }
            score -= (doublePawn * 0.5);

        }
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
