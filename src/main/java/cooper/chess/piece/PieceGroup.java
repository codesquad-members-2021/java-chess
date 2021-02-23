package cooper.chess.piece;

import java.util.*;

public class PieceGroup {
    public static final int PIECE_LIST_MAX = 16;

    private final Map<Color, List<Piece>> pieceListMap;

    public PieceGroup() {
        this.pieceListMap = new HashMap<>();
        this.pieceListMap.put(Color.WHITE, new ArrayList<>());
        this.pieceListMap.put(Color.BLACK, new ArrayList<>());

        initialize();
    }

    private void initialize() {
        initWhitePiece();
        initBlackPiece();
    }

    private void initWhitePiece() {
        List<Piece> pieceList = getPieceList(Color.WHITE);

        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());

        for (int pawnCount = 0; pawnCount < PIECE_LIST_MAX / 2; pawnCount++) {
            pieceList.add(Piece.createWhitePawn());
        }
    }

    private void initBlackPiece() {
        List<Piece> pieceList = getPieceList(Color.BLACK);

        for (int pawnCount = 0; pawnCount < PIECE_LIST_MAX / 2; pawnCount++) {
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

    public List<Piece> getPieceList(Color color) {
        return pieceListMap.get(color);
    }

    public int size() {
        return pieceListMap.get(Color.BLACK).size() +
                pieceListMap.get(Color.WHITE).size();
    }

    public void add(Piece piece) {
        List<Piece> pieceList = getPieceList(piece.getColor());

        if (pieceList.size() >= PIECE_LIST_MAX) {
            return;
        }

        pieceList.add(piece);
    }

    public Piece findPawn(int index, Color color) {
        List<Piece> pieceList = getPieceList(color);

        if (pieceList.size() == 0) {
            throw new IllegalArgumentException("size가 0입니다.");
        }

        if ((0 > index) || (index >= pieceList.size())) {
            throw new IllegalArgumentException("범위를 벗어나는 인덱스 입니다.");
        }

        return pieceList.get(index);
    }
}
