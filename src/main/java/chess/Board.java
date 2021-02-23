package chess;

import pieces.Color;
import pieces.Piece;
import pieces.Type;

import java.util.Arrays;

import static utils.StringUtils.NEWLINE;

public class Board {

    private final Piece[] squares;
    private final int RANKS = 8;
    private final int FILES = 8;
    private final PositionParser positionParser = new PositionParser();

    public Board() {
        squares = new Piece[RANKS * FILES];
        initializeEmpty();
    }

    public String showBoard() {
        StringBuilder squares = new StringBuilder();
        int lineSeparatorCount = 0;
        for (Piece piece : this.squares) {
            squares.append(piece.getRepresentation());
            lineSeparatorCount++;
            if (lineSeparatorCount % FILES == 0) {
                squares.append(NEWLINE);
            }
        }
        return squares.toString();
    }

    public int pieceCount() {
        int pieceCount = 0;
        for (Piece piece : squares) {
            if (piece.getType() != Type.NO_PIECE) {
                pieceCount++;
            }
        }
        return pieceCount;
    }

    public int countPieceByColorAndType(Color color, Type type) {
        int count = 0;
        for (Piece piece : squares) {
            if (piece.getType() == type && piece.getColor() == color) {
                count++;
            }
        }
        return count;
    }

    public Piece findPiece(String position) {
        int rankIndex = positionParser.parseRankIndex(position);
        int fileIndex = positionParser.parseFileIndex(position);
        return squares[rankIndex * FILES + fileIndex];
    }

    public void move(String position, Piece piece) {
        int rankIndex = positionParser.parseRankIndex(position);
        int fileIndex = positionParser.parseFileIndex(position);
        setByIndex(rankIndex, fileIndex, piece);
    }

    public double calculatePoint(Color color) {
        double resultPoint = 0;

        for (int j = 0; j < FILES; j++) {
            int pawnCount = 0;
            for (int i = 0; i < RANKS; i++) {
                Piece piece = getByIndex(i, j);
                Type type = piece.getType();
                if (piece.getColor() == color) {
                    resultPoint += type.getPoint();
                    if (type == Type.PAWN) {
                        pawnCount++;
                    }
                }
            }
            if (pawnCount >= 2) {
                resultPoint -= pawnCount * 0.5;
            }
        }
        return resultPoint;
    }

    private Piece getByIndex(int rank, int file) {
        return squares[rank * FILES + file];
    }

    private void setByIndex(int rank, int file, Piece piece) {
        squares[rank * FILES + file] = piece;
    }

    public void initializeEmpty() {
        Arrays.fill(squares, Piece.createBlank());
    }

    public void initialize() {
        initializeEmpty();
        initializeRank1();
        initializeRank2();
        initializeRank7();
        initializeRank8();
    }

    private void initializeRank8() {
        squares[0] = Piece.createBlackRook();
        squares[1] = Piece.createBlackKnight();
        squares[2] = Piece.createBlackBishop();
        squares[3] = Piece.createBlackQueen();
        squares[4] = Piece.createBlackKing();
        squares[5] = Piece.createBlackBishop();
        squares[6] = Piece.createBlackKnight();
        squares[7] = Piece.createBlackRook();
    }

    private void initializeRank7() {
        int rankBaseIndex = FILES;
        Arrays.fill(squares, rankBaseIndex, rankBaseIndex + FILES, Piece.createBlackPawn());
    }

    private void initializeRank2() {
        int rankBaseIndex = 6 * FILES;
        Arrays.fill(squares, rankBaseIndex, rankBaseIndex + FILES, Piece.createWhitePawn());
    }

    private void initializeRank1() {
        int rankBaseIndex = 7 * FILES;
        squares[rankBaseIndex    ] = Piece.createWhiteRook();
        squares[rankBaseIndex + 1] = Piece.createWhiteKnight();
        squares[rankBaseIndex + 2] = Piece.createWhiteBishop();
        squares[rankBaseIndex + 3] = Piece.createWhiteQueen();
        squares[rankBaseIndex + 4] = Piece.createWhiteKing();
        squares[rankBaseIndex + 5] = Piece.createWhiteBishop();
        squares[rankBaseIndex + 6] = Piece.createWhiteKnight();
        squares[rankBaseIndex + 7] = Piece.createWhiteRook();
    }

    private class PositionParser {
        private int parseRankIndex(String position) {
            char rank = position.charAt(1);
            int rankPosition = Character.getNumericValue(rank);
            return RANKS - rankPosition;
        }
        private int parseFileIndex(String position) {
            char file = position.charAt(0);
            return file - 'a';
        }
    }

}
