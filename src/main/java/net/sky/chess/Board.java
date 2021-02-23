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

    public void initialize() {
        initializeBlackPieces();
        initializeBlackPawns();
        initializeBlank();
        initializeBlank();
        initializeBlank();
        initializeBlank();
        initializeWhitePawns();
        initializeWhitePieces();

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

    private void initializeWhitePawns() {
        initializePawns(whitePieceMaker);
    }

    private void initializeBlackPawns() {
        initializePawns(blackPieceMaker);
    }

    private void initializePawns(PieceMaker pieceMaker) {
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_SIZE; i++) {
            rank.add(pieceMaker.createPawn());
        }
        board.add(rank);
    }

    private void initializeWhitePieces() {
        initializePieces(whitePieceMaker);
    }

    private void initializeBlackPieces() {
        initializePieces(blackPieceMaker);
    }

    private void initializePieces(PieceMaker pieceMaker) {
        Rank rank = new Rank();
        rank.add(pieceMaker.createRook());
        rank.add(pieceMaker.createKnight());
        rank.add(pieceMaker.createBishop());
        rank.add(pieceMaker.createQueen());
        rank.add(pieceMaker.createKing());
        rank.add(pieceMaker.createBishop());
        rank.add(pieceMaker.createKnight());
        rank.add(pieceMaker.createRook());
        board.add(rank);
    }

    private void initializeBlank() {
        Rank rank = new Rank();
        for (int i = 0; i < BOARD_SIZE; i++) {
            rank.add(PieceMaker.createBlank());
        }
        board.add(rank);
    }

    private String getPiecesResult(Rank rank) {
        StringBuilder result = new StringBuilder();
        for (Piece piece : rank.getRank()) {
            result.append(piece.getRepresentation());
        }
        return result.toString();
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

}
