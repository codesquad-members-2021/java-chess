package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;

import java.util.LinkedHashMap;
import java.util.Map;

import net.sky.pieces.Color;
import net.sky.pieces.Piece;
import net.sky.pieces.PieceMaker;
import net.sky.pieces.PieceType;
import net.sky.pieces.Position;

public class Board {

    private final int BOARD_SIZE = 8;
    private Map<Position, Piece> piecePositions = new LinkedHashMap<>();
    private final PieceMaker whitePieceMaker = new PieceMaker(Color.WHITE);
    private final PieceMaker blackPieceMaker = new PieceMaker(Color.BLACK);

    public void initialize() {
        int x = 0;
        initializePieces(x++, blackPieceMaker);
        initializePawns(x++, blackPieceMaker);
        initializeBlanks(x++);
        initializeBlanks(x++);
        initializeBlanks(x++);
        initializeBlanks(x++);
        initializePawns(x++, whitePieceMaker);
        initializePieces(x++, whitePieceMaker);
    }

    public void initializeEmpty() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            initializeBlanks(x);
        }

    }

    private void initializePieces(int x, PieceMaker pieceMaker) {
        int y = 0;
        piecePositions.put(new Position(x, y++), pieceMaker.createRook());
        piecePositions.put(new Position(x, y++), pieceMaker.createKnight());
        piecePositions.put(new Position(x, y++), pieceMaker.createBishop());
        piecePositions.put(new Position(x, y++), pieceMaker.createQueen());
        piecePositions.put(new Position(x, y++), pieceMaker.createKing());
        piecePositions.put(new Position(x, y++), pieceMaker.createBishop());
        piecePositions.put(new Position(x, y++), pieceMaker.createKnight());
        piecePositions.put(new Position(x, y++), pieceMaker.createRook());
    }

    private void initializePawns(int x, PieceMaker pieceMaker) {
        for (int y = 0; y < BOARD_SIZE; y++) {
            piecePositions.put(new Position(x, y), pieceMaker.createPawn());
        }
    }

    private void initializeBlanks(int x) {
        for (int y = 0; y < BOARD_SIZE; y++) {
            piecePositions.put(new Position(x, y), PieceMaker.createBlank());
        }
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder result = new StringBuilder();
        int initRank = 8;
        int resultSize = 0;

        for (Piece piece : piecePositions.values()) {
            resultSize++;
            result.append(piece.getRepresentation());
            if (resultSize % BOARD_SIZE == 0) {
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

        for (Piece piece : piecePositions.values()) {
            if (color == piece.getColor()) {
                point += piece.getPoint();
            }
        }

        for (int file = 0; file < BOARD_SIZE; file++) {
            point -= (filePawnNum(file, color) / 2);
        }

        return point;
    }

    private double filePawnNum(int file, Color color) {
        double pawnNum = 0;

        for (int rank = 0; rank < BOARD_SIZE; rank++) {
            Position position = new Position(rank, file);
            Piece piece = piecePositions.get(position);

            if (piece.getPieceType() == PieceType.PAWN && color == piece.getColor()) {
                pawnNum += 1;
            }
        }
        return pawnNum > 1 ? pawnNum : 0;
    }
}
