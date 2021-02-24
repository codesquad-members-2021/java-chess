package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import net.sky.pieces.Position;

public class Board {

    private final int START_RANK = 8;
    private final int END_RANK = 1;
    private final char START_FILE = 'a';
    private final char END_FILE = 'h';
    private Map<Position, Piece> piecePositions = new LinkedHashMap<>();
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
        final int FILE_SIZE = 8;
        int initRank = START_RANK;
        int resultSize = 0;

        for (Piece piece : piecePositions.values()) {
            resultSize++;
            result.append(piece.getRepresentation());
            if (resultSize % FILE_SIZE == 0) {
                result.append(appendNewLine(" " + initRank--));
            }
        }
        result.append(appendNewLine(""));
        result.append(appendNewLine("abcdefgh"));

        return result.toString();
    }

    public int pieceCount(Piece piece) {
        int pieceCount = 0;

        for (Piece p : piecePositions.values()) {
            if (p.equals(piece)) {
                pieceCount += 1;
            }
        }

        return pieceCount;
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
            char file = position.getFile();
            List<Piece> fileList = getFile(file, color);
            if (color == piece.getColor()) {
                point += piece.getPoint(fileList);
            }
        }

        return point;
    }

    private List<Piece> getFile(char file, Color color) {
        List<Piece> fileList = new ArrayList<>();

        for (int rank = START_RANK; rank >= END_RANK; rank--) {
            Position position = new Position(rank, file);
            Piece piece = piecePositions.get(position);
            if (color == piece.getColor()) {
                fileList.add(piece);
            }
        }

        return fileList;
    }

    public String sortByScore(Color color) {
        StringBuilder result = new StringBuilder();
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : piecePositions.values()) {
            if (piece.getColor() == color) {
                pieces.add(piece);
            }
        }

        Collections.sort(pieces,
            (piece1, piece2) -> Double.compare(piece2.getDefaultPoint(), piece1.getDefaultPoint()));

        for (Piece piece : pieces) {
            result.append(piece);
        }

        return result.toString();
    }

}
