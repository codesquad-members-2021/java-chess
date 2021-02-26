package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import net.sky.pieces.PieceType;
import net.sky.pieces.Position;

public class Board {

    private final int START_RANK = 8;
    private final int END_RANK = 1;
    private final char START_FILE = 'a';
    private final char END_FILE = 'h';
    private Map<Position, Piece> piecePositions = new HashMap<>();
    private final PieceMaker whitePieceMaker = new PieceMaker(Color.WHITE);
    private final PieceMaker blackPieceMaker = new PieceMaker(Color.BLACK);

    public void initialize() {
        int rank = START_RANK;
        initializePieces(rank--, blackPieceMaker);
        initializePawns(rank--, blackPieceMaker);
        initializeBlanks(rank--);
        initializeBlanks(rank--);
        initializeBlanks(rank--);
        initializeBlanks(rank--);
        initializePawns(rank--, whitePieceMaker);
        initializePieces(rank, whitePieceMaker);
    }

    public void initializeEmpty() {
        for (int rank = START_RANK; rank >= END_RANK; rank--) {
            initializeBlanks(rank);
        }

    }

    private void initializePieces(int rank, PieceMaker pieceMaker) {
        char file = START_FILE;

        piecePositions.put(new Position(rank, file++), pieceMaker.createRook());
        piecePositions.put(new Position(rank, file++), pieceMaker.createKnight());
        piecePositions.put(new Position(rank, file++), pieceMaker.createBishop());
        piecePositions.put(new Position(rank, file++), pieceMaker.createQueen());
        piecePositions.put(new Position(rank, file++), pieceMaker.createKing());
        piecePositions.put(new Position(rank, file++), pieceMaker.createBishop());
        piecePositions.put(new Position(rank, file++), pieceMaker.createKnight());
        piecePositions.put(new Position(rank, file), pieceMaker.createRook());
    }

    private void initializePawns(int rank, PieceMaker pieceMaker) {
        for (char file = START_FILE; file <= END_FILE; file++) {
            piecePositions.put(new Position(rank, file), pieceMaker.createPawn());
        }
    }

    private void initializeBlanks(int rank) {
        for (char file = START_FILE; file <= END_FILE; file++) {
            piecePositions.put(new Position(rank, file), PieceMaker.createBlank());
        }
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        int initRank = START_RANK;

        for (int rank = START_RANK; rank >= END_RANK; rank--) {
            for (char file = START_FILE; file <= END_FILE; file++) {
                Position position = new Position(rank, file);
                result.append(piecePositions.get(position));
            }
            result.append(appendNewLine(" " + initRank--));
        }

        result.append(appendNewLine(""));
        result.append(appendNewLine("abcdefgh"));

        return result.toString();
    }

    public int pieceCount(Piece piece) {
        return (int) piecePositions.values().stream().filter((p) -> p.equals(piece)).count();
    }

    public Piece findPiece(Position position) {
        return piecePositions.get(position);
    }

    public void move(Position position, Piece piece) {
        piecePositions.put(position, piece);
    }

    public double calculatePoint(Color color) {
        double point = 0;

        for (Position position : piecePositions.keySet()) {
            Piece piece = piecePositions.get(position);
            if (piece.isMatchingColor(color)) {
                point += piece.getPoint();
            }

        }

        for (char file = START_FILE; file <= END_FILE; file++) {
            point -= countPawnByFile(file, color);
        }

        return point;
    }

    private double countPawnByFile(char file, Color color) {
        double count = 0;

        for (int rank = START_RANK; rank >= END_RANK; rank--) {
            Position position = new Position(rank, file);
            Piece piece = piecePositions.get(position);
            if (piece.isMatchingColor(color) && piece.isMatchingType(PieceType.PAWN)) {
                count += 1;
            }
        }

        if (count > 1) {
            return count / 2;
        }

        return 0;
    }

    public String sortByScore(Color color) {
        StringBuilder result = new StringBuilder();
        List<Piece> pieces = new ArrayList<>();

        for (Piece piece : piecePositions.values()) {
            if (piece.isMatchingColor(color)) {
                pieces.add(piece);
            }
        }

        Collections.sort(pieces,
            (piece1, piece2) -> Double.compare(piece2.getPoint(), piece1.getPoint()));

        for (Piece piece : pieces) {
            result.append(piece);
        }

        return result.toString();
    }

}
