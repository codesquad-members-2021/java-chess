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

    public Board() {
        squares = new Piece[RANKS * FILES];
        initializeEmpty();
    }

    public void initialize() {
        initializeEmpty();
        initializeRank1();
        initializeRank2();
        initializeRank7();
        initializeRank8();
    }

    public void initializeEmpty() {
        Arrays.fill(squares, Piece.createBlank());
    }

    private void initializeRank1() {
        set(File.A, Rank.ONE, Piece.createWhiteRook());
        set(File.B, Rank.ONE, Piece.createWhiteKnight());
        set(File.C, Rank.ONE, Piece.createWhiteBishop());
        set(File.D, Rank.ONE, Piece.createWhiteQueen());
        set(File.E, Rank.ONE, Piece.createWhiteKing());
        set(File.F, Rank.ONE, Piece.createWhiteBishop());
        set(File.G, Rank.ONE, Piece.createWhiteKnight());
        set(File.H, Rank.ONE, Piece.createWhiteRook());
    }

    private void initializeRank2() {
        set(File.A, Rank.TWO, Piece.createWhitePawn());
        set(File.B, Rank.TWO, Piece.createWhitePawn());
        set(File.C, Rank.TWO, Piece.createWhitePawn());
        set(File.D, Rank.TWO, Piece.createWhitePawn());
        set(File.E, Rank.TWO, Piece.createWhitePawn());
        set(File.F, Rank.TWO, Piece.createWhitePawn());
        set(File.G, Rank.TWO, Piece.createWhitePawn());
        set(File.H, Rank.TWO, Piece.createWhitePawn());
    }

    private void initializeRank7() {
        set(File.A, Rank.SEVEN, Piece.createBlackPawn());
        set(File.B, Rank.SEVEN, Piece.createBlackPawn());
        set(File.C, Rank.SEVEN, Piece.createBlackPawn());
        set(File.D, Rank.SEVEN, Piece.createBlackPawn());
        set(File.E, Rank.SEVEN, Piece.createBlackPawn());
        set(File.F, Rank.SEVEN, Piece.createBlackPawn());
        set(File.G, Rank.SEVEN, Piece.createBlackPawn());
        set(File.H, Rank.SEVEN, Piece.createBlackPawn());
    }

    private void initializeRank8() {
        set(File.A, Rank.EIGHT, Piece.createBlackRook());
        set(File.B, Rank.EIGHT, Piece.createBlackKnight());
        set(File.C, Rank.EIGHT, Piece.createBlackBishop());
        set(File.D, Rank.EIGHT, Piece.createBlackQueen());
        set(File.E, Rank.EIGHT, Piece.createBlackKing());
        set(File.F, Rank.EIGHT, Piece.createBlackBishop());
        set(File.G, Rank.EIGHT, Piece.createBlackKnight());
        set(File.H, Rank.EIGHT, Piece.createBlackRook());
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
        return squares[calculateIndexByString(position)];
    }

    public void move(String position, Piece piece) {
        squares[calculateIndexByString(position)] = piece;
    }

    public double calculatePoint(Color color) {
        double resultPoint = 0;
        for (File file : File.values()) {
            resultPoint += calculateFilePoint(file, color);
        }
        return resultPoint;
    }

    private double calculateFilePoint(File file, Color color) {
        int pawnCount = 0;
        double filePoint = 0;

        for (Rank rank : Rank.values()) {
            Piece piece = get(file, rank);
            Type type = piece.getType();
            if (piece.getColor() == color) {
                filePoint += type.getPoint();
            }
            if (piece.getColor() == color && type == Type.PAWN) {
                pawnCount++;
            }
        }
        if (pawnCount >= 2) {
            filePoint -= pawnCount * 0.5;
        }

        return filePoint;
    }

    private int calculateIndex(File file, Rank rank) {
        return rank.getIndex() * FILES + file.getIndex();
    }

    private int calculateIndexByString(String position) {
        Rank rank = parseRank(position);
        File file = parseFile(position);
        return calculateIndex(file, rank);
    }

    private Piece get(File file, Rank rank) {
        return squares[calculateIndex(file, rank)];
    }

    private void set(File file, Rank rank, Piece piece) {
        squares[calculateIndex(file, rank)] = piece;
    }

    private Rank parseRank(String position) {
        char rank = position.charAt(1);
        int rankPosition = Character.getNumericValue(rank);
        return Rank.getByInt(rankPosition);
    }

    private File parseFile(String position) {
        char file = Character.toUpperCase(position.charAt(0));
        return File.valueOf(Character.toString(file));
    }

}
