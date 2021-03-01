package chess;

import piece.*;
import piece.attribute.*;

import java.util.*;

import static piece.PieceFactory.createPiece;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final Map<Position, Piece> squares = new LinkedHashMap<>();

    public Board() {
        initialize();
    }

    public void initialize() {
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

    public void initializeEmpty() {
        for (Position position : squares.keySet()) {
            set(position, createPiece(Color.NO_COLOR, Type.BLANK, position));
        }
    }

    private void initRank(Color color, int rank, Type type) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            addPiece(createPiece(color, type, new Position((char) (i + 'a'), rank)));
        }
    }

    private void initBlankSquares(int rank) {
        initRank(Color.NO_COLOR, rank, Type.BLANK);
    }

    private void initPawns(Color color, int rank) {
        initRank(color, rank, Type.PAWN);
    }

    private void initPiecesExceptPawns(Color color, int rank) {
        addPiece(createPiece(color, Type.ROOK, new Position('a', rank)));
        addPiece(createPiece(color, Type.KNIGHT, new Position('b', rank)));
        addPiece(createPiece(color, Type.BISHOP, new Position('c', rank)));
        addPiece(createPiece(color, Type.QUEEN, new Position('d', rank)));
        addPiece(createPiece(color, Type.KING, new Position('e', rank)));
        addPiece(createPiece(color, Type.BISHOP, new Position('f', rank)));
        addPiece(createPiece(color, Type.KNIGHT, new Position('g', rank)));
        addPiece(createPiece(color, Type.ROOK, new Position('h', rank)));
    }

    public Map<Position, Piece> getSquares() {
        return squares;
    }

    public void addPiece(Piece piece) {
        squares.put(piece.getPosition(), piece);
    }

    public Piece findPiece(Position position) {
        return squares.get(position);
    }

    public int getNumberOf(Color color, Type type) {
        return (int) squares.values()
                .stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
    }

    public void move(Position before, Position after) {
        Piece piece = findPiece(before);
        if (piece.isMovable(after) && !piece.isSameColor(findPiece(after))) {
            set(after, piece);
            set(before, createPiece(Color.NO_COLOR, Type.BLANK, before));
        }
    }

    private void set(Position position, Piece piece) {
        squares.replace(position, piece);
        piece.setPosition(position);
    }

    public double calculatePoint(Color color) {
        double point = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            List<Piece> pieces = getPiecesInFile((char) (i + 'a'));
            point += getSum(pieces, color);
        }
        return point;
    }

    private List<Piece> getPiecesInFile(char file) {
        List<Piece> pieces = new ArrayList<>();
        for (int rank = 1; rank <= BOARD_SIZE; rank++) {
            pieces.add(findPiece(new Position(file, rank)));
        }
        return Collections.unmodifiableList(pieces);
    }

    private double getSum(List<Piece> pieces, Color color) {
        return pieces.stream().filter(piece -> piece.isSameColorAs(color))
                .filter(piece -> !piece.isPawn())
                .reduce(0.0, (result, piece) -> result + piece.getPoint(), Double::sum)
                + getPawnPoint(pieces, color);
    }

    private double getPawnPoint(List<Piece> pieces, Color color) {
        double pawnPoint = Type.PAWN.getDefaultPoint();
        long pawnCount = pieces.stream()
                .filter(piece -> piece.getColor() == color && piece.getType() == Type.PAWN)
                .count();
        if (pawnCount > 1) {
            return (pawnPoint / 2) * pawnCount;
        }
        return pawnPoint * pawnCount;
    }

    public List<Piece> getPiecesSortedByPoint(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : squares.values()) {
            if (piece.getColor() == color) {
                pieces.add(piece);
            }
        }
        Collections.sort(pieces);
        return Collections.unmodifiableList(pieces);
    }
}
