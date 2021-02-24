package cooper.chess.piece;

import cooper.chess.Board;

import java.util.*;

public class PieceGroup {
    private static int WHITE_PIECE_SIZE;
    private static int BLACK_PIECE_SIZE;

    private final List<Piece> pieceList;
    private PointCalculator pointCalculator;

    public PieceGroup() {
        this.pieceList = new ArrayList<>();
        initialize();
        this.pointCalculator = new PointCalculator(pieceList);
    }

    private void initialize() {
        initWhitePiece();
        setWhiteSize();

        initBlank();

        initBlackPiece();
        setBlackSize();
    }

    private void initWhitePiece() {
        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());

        for (int pawnCount = 0; pawnCount < 8; pawnCount++) {
            pieceList.add(Piece.createWhitePawn());
        }
    }

    private void initBlank() {
        final int blank_max = 32;

        for (int blankCnt = 0; blankCnt < blank_max; blankCnt++) {
            pieceList.add(Piece.createBlank());
        }
    }

    private void initBlackPiece() {
        for (int pawnCount = 0; pawnCount < 8; pawnCount++) {
            pieceList.add(Piece.createBlackPawn());
        }

        pieceList.add(Piece.createBlackRook());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackQueen());
        pieceList.add(Piece.createBlackKing());
        pieceList.add(Piece.createBlackBishop());
        pieceList.add(Piece.createBlackKnight());
        pieceList.add(Piece.createBlackRook());
    }

    private void setWhiteSize() {
        WHITE_PIECE_SIZE = 16;
    }

    private void setBlackSize() {
        BLACK_PIECE_SIZE = 16;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public int size() {
        return WHITE_PIECE_SIZE + BLACK_PIECE_SIZE;
    }

    public int getPieceCount(Color color, Type type) {
        return (int)pieceList.stream()
                .filter(piece -> piece.getColor() == color)
                .filter(piece -> piece.getType() == type)
                .count();
    }

    public Piece findPiece(Position position) {
        return pieceList.get(getListIndex(position));
    }

    public void initializeEmpty() {
        for (int index = 0; index < pieceList.size(); index++) {
            pieceList.set(index, Piece.createBlank());
        }
    }

    public void addPiece(Position position, Piece piece) {
        pieceList.set(getListIndex(position), piece);
    }

    private int getListIndex(Position position) {
        return (Board.BOARD_SIZE * position.getyPos()) + position.getxPos();
    }

    public void move(Position before, Position after) {
        pieceList.set(getListIndex(after), findPiece(before));
        pieceList.set(getListIndex(before), Piece.createBlank());
    }

    public double calculatePoint(Color color) {
        return pointCalculator.calculate(color);
    }
}
