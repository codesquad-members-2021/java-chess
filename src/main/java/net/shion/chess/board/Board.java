package net.shion.chess.board;

import net.shion.chess.pieces.Piece;
import net.shion.chess.pieces.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static net.shion.chess.pieces.Piece.*;
import static net.shion.chess.utils.StringUtils.appendNewLine;

public class Board {
    public static final int MAX_RANK = 8;

    private final List<Rank> ranks = new ArrayList<>();

    public Board() {
        initialize();
    }

    public void initialize() {
        ranks.addAll(Arrays.asList(
            Rank.createInitialRank1(),
            Rank.createInitialRank2(),
            Rank.createBlankRank(3),
            Rank.createBlankRank(4),
            Rank.createBlankRank(5),
            Rank.createBlankRank(6),
            Rank.createInitialRank7(),
            Rank.createInitialRank8()
        ));
    }

    public void initializeEmpty() {
        for (int rank = 0; rank < MAX_RANK; rank++) {
            ranks.set(rank, getBlankRank(rank));
        }
    }

    private Rank getBlankRank(int rank) {
        Rank blankRank = Rank.createBlankRank(rank);
        return blankRank;
    }

    public int pieceCount() {
        return ranks.get(0).size()
                + ranks.get(1).size()
                + ranks.get(6).size()
                + ranks.get(7).size();
    }

    public int pieceCountOf(Color color, Type type) {
        int pieceCount = 0;
        for (int rank = 0; rank < MAX_RANK; rank++) {
            pieceCount += ranks.get(rank).pieceCountOf(color, type);

        }
        return pieceCount;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        Piece target = ranks.get(pos.rank()).getPieceOf(pos.file());
        return target;
    }

    public void move(Piece piece) {
        Position position = piece.getPosition();
        ranks.get(position.rank()).set(position.file(), piece);
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();

        chessBoard.append(appendNewLine(getRankResult(ranks.get(7)) + "  8 (rank 8)"))
                .append(appendNewLine(getRankResult(ranks.get(6)) + "  7"))
                .append(appendNewLine(getRankResult(ranks.get(5)) + "  6"))
                .append(appendNewLine(getRankResult(ranks.get(4)) + "  5"))
                .append(appendNewLine(getRankResult(ranks.get(3)) + "  4"))
                .append(appendNewLine(getRankResult(ranks.get(2)) + "  3"))
                .append(appendNewLine(getRankResult(ranks.get(1)) + "  2"))
                .append(appendNewLine(getRankResult(ranks.get(0)) + "  1 (rank 1)"))
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
        List<Piece> remainedPiecesOfColor = ranks.stream()
                .flatMap(rank -> rank.getPiecesOf(color).stream())
                .sorted()
                .collect(Collectors.toList());
        return remainedPiecesOfColor;
    }

}
