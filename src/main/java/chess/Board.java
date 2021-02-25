package chess;

import piece.Piece;
import piece.attribute.*;

import java.util.*;

import static piece.PieceFactory.createPiece;


public class Board {
    private final Map<Position, Piece> squares = new LinkedHashMap<>();
    public final int BOARD_SIZE = 8;

    public Map<Position, Piece> getSquares() {
        return squares;
    }

    public void addPiece(Position position, Piece piece) {
        squares.put(position, piece);
    }

    void initialize() {
        squares.clear();
        initPiecesExceptPawns(Color.BLACK, 8);
        initPawns(Color.BLACK, 7);
        initBlankSquares(6);
        initBlankSquares(5);
        initBlankSquares(4);
        initBlankSquares(3);
        initPawns(Color.WHITE, 2);
        initPiecesExceptPawns(Color.WHITE, 1);
    }

    void initializeEmpty() {
        for (Position position : squares.keySet()) {
            set(position, createPiece(Color.NO_COLOR, Type.BLANK));
        }
    }

    private void initRank(Color color, int rank, Type type) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addPiece(new Position((char) (i + 'a'), rank), createPiece(color, type));
        }
    }

    private void initBlankSquares(int rank) {
        initRank(Color.NO_COLOR, rank, Type.BLANK);
    }

    private void initPawns(Color color, int rank) {
        initRank(color, rank, Type.PAWN);
    }

    private void initPiecesExceptPawns(Color color, int rank) {
        addPiece(new Position('a', rank), createPiece(color, Type.ROOK));
        addPiece(new Position('b', rank), createPiece(color, Type.KNIGHT));
        addPiece(new Position('c', rank), createPiece(color, Type.BISHOP));
        addPiece(new Position('d', rank), createPiece(color, Type.QUEEN));
        addPiece(new Position('e', rank), createPiece(color, Type.KING));
        addPiece(new Position('f', rank), createPiece(color, Type.BISHOP));
        addPiece(new Position('g', rank), createPiece(color, Type.KNIGHT));
        addPiece(new Position('h', rank), createPiece(color, Type.ROOK));
    }



    public int getNumberOfPieces(Color color, Type type) {
        return (int) squares.values()
                .stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
    }

    public Piece findPiece(Position position) {
        return squares.get(position);
    }

    public void move(Position before, Position after) {
        set(after, findPiece(before));
        set(before, createPiece(Color.NO_COLOR, Type.BLANK));
    }

    private void set(Position position, Piece piece) {
        squares.replace(position, piece);
    }

    public double calculatePoint(Color color) {
        double point = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            List<Piece> pieces = getPiecesInFile((char) (i + 'a'));
            point = getSum(pieces, color, point);
        }
        return point;
    }

    private double getSum(List<Piece> pieces, Color color, double point) {
        for (Piece piece : pieces) {
            if (!(piece.getColor() == color)) continue;
            if (piece.getType() == Type.PAWN) {
                point += getPawnPoint(pieces);
                continue;
            }
            point += piece.getPoint();
        }
        return point;
    }

    private List<Piece> getPiecesInFile(char file) {
        List<Piece> pieces = new ArrayList<>();
        for (int rank = 1; rank <= BOARD_SIZE; rank++) {
            pieces.add(findPiece(new Position(file, rank)));
        }
        return pieces;
    }

    private double getPawnPoint(List<Piece> pieces) {
        double pawnPoint = Type.PAWN.getDefaultPoint();
        int pawnCount = 0;
        for (Piece piece : pieces) {
            if (piece.getType() == Type.PAWN) {
                pawnCount++;
            }
        }
        return pawnCount > 1 ? pawnPoint / 2 : pawnPoint;
    }

    public List<Piece> getPiecesSortedByPoint(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : squares.values()) {
            if (piece.getColor() == color) {
                pieces.add(piece);
            }
        }
        Collections.sort(pieces);
        return pieces;
    }
}

