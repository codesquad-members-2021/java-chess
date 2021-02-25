package chess;

import piece.Blank;
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

    Board() {

    }
    public void addPiece(Piece piece) {
        squares.put(piece.getPosition(), piece);
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
        Piece piece = findPiece(before);
        if (!piece.isSameColor(findPiece(after)) && piece.isMovable(after)) {
            set(after, piece);
            set(before, new Blank(Color.NO_COLOR, before));
            return;
        }
            System.err.println("이동할 수 없는 위치입니다. 명령어를 다시 입력해주세요.");
    }

    private void set(Position position, Piece piece) {
        squares.replace(position, piece);
        piece.setPosition(position);
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

