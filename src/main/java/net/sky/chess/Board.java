package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;

public class Board {

    private List<Rank> board = new ArrayList<>();
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
    }

    private void initializeWhitePawns() {
        initializePawns(whitePieceMaker);
    }

    private void initializeBlackPawns() {
        initializePawns(blackPieceMaker);
    }

    private void initializePawns(PieceMaker pieceMaker) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
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
        for (int i = 0; i < 8; i++) {
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

        for (Rank rank : board) {
            result.append(appendNewLine(getPiecesResult(rank)));
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

}
