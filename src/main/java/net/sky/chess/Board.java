package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import net.sky.pieces.Position;

public class Board {

    private Map<Position, Piece> piecePositions = new HashMap<>();
    private List<Rank> board = new ArrayList<>();
    private final int BOARD_SIZE = 8;
    private final PieceMaker whitePieceMaker = new PieceMaker(Color.WHITE);
    private final PieceMaker blackPieceMaker = new PieceMaker(Color.BLACK);
    private final RankMaker whiteRankMaker = new RankMaker(whitePieceMaker);
    private final RankMaker blackRankMaker = new RankMaker(blackPieceMaker);

    public void initialize() {
        board.add(blackRankMaker.createPieceRank());
        board.add(blackRankMaker.createPawnRank());
        board.add(RankMaker.createBlankRank());
        board.add(RankMaker.createBlankRank());
        board.add(RankMaker.createBlankRank());
        board.add(RankMaker.createBlankRank());
        board.add(whiteRankMaker.createPawnRank());
        board.add(whiteRankMaker.createPieceRank());

        initializePosition();
    }

    public void initializeEmpty() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(RankMaker.createBlankRank());
        }

        initializePosition();
    }

    private void initializePosition() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                Piece piece = board.get(x).getRank().get(y);
                piecePositions.put(new Position(x, y), piece);
            }
        }
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        int initRank = 8;

        for (Rank rank : board) {
            result.append(getPiecesResult(rank))
                .append(appendNewLine(" " + initRank--));
        }

        result.append(appendNewLine(""));
        result.append(appendNewLine("abcdefgh"));

        return result.toString();
    }

    private String getPiecesResult(Rank rank) {
        StringBuilder result = new StringBuilder();
        for (Piece piece : rank.getRank()) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
    }

    public int pieceCount(Piece piece) {
        int pieceCount = 0;

        for (Rank rank : board) {
            pieceCount += rank.pieceCount(piece);
        }

        return pieceCount;
    }

    public Piece findPiece(Position position) {
        return piecePositions.get(position);
    }

    public void move(Position position, Piece piece) {
        piecePositions.put(position, piece);
        int x = position.getX();
        int y = position.getY();
        board.get(x).getRank().set(y, piece);
    }

}
