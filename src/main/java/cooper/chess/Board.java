package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final String BLANK = "........";

    private final PieceGroup pieceGroup;

    public Board() {
        this.pieceGroup = new PieceGroup(createPawnGroup());
    }

    private Map<Color, List<Piece>> createPawnGroup() {
        Map<Color, List<Piece>> pawnListMap = new HashMap<>();

        pawnListMap.put(Color.WHITE, new ArrayList<>());
        pawnListMap.put(Color.BLACK, new ArrayList<>());

        return pawnListMap;
    }

    public void initialize() {
        initWhitePiece();
        initBlackPiece();
    }

    private void initWhitePiece() {
        List<Piece> pieceList = pieceGroup.getPawnList(Color.WHITE);

        pieceList.add(Piece.createWhiteRook());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteQueen());
        pieceList.add(Piece.createWhiteKing());
        pieceList.add(Piece.createWhiteBishop());
        pieceList.add(Piece.createWhiteKnight());
        pieceList.add(Piece.createWhiteRook());

        for (int pawnCount = 0; pawnCount < BOARD_SIZE; pawnCount++) {
            pieceList.add(Piece.createWhitePawn());
        }
    }

    private void initBlackPiece() {
        List<Piece> pieceList = pieceGroup.getPawnList(Color.BLACK);

        for (int pawnCount = 0; pawnCount < BOARD_SIZE; pawnCount++) {
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

    public void add(Piece piece) {
        List<Piece> pieceList = pieceGroup.getPawnList(piece.getColor());

        if (pieceList.size() >= 8) {
            return;
        }

        pieceList.add(piece);
    }

    public int pieceCount() {
        return pieceGroup.size();
    }

    public Piece findPawn(int index, Color color) {
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        if (pieceList.size() == 0) {
            throw new IllegalArgumentException("size가 0입니다.");
        }

        if ((0 > index) || (index >= pieceList.size())) {
            throw new IllegalArgumentException("범위를 벗어나는 인덱스 입니다.");
        }

        return pieceList.get(index);
    }

    public String showBoard() {
        appendNewLine(getPawnsResult(Color.WHITE));
        appendNewLine(BLANK);
        appendNewLine(BLANK);
        appendNewLine(BLANK);
        appendNewLine(BLANK);
        appendNewLine(getPawnsResult(Color.BLACK));

        return convertToString();
    }

    private String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        for (int col = 0; col < BOARD_SIZE; col++) {
            sb.append(pieceList.get(col).getRepresentation());
        }

        sb.append(NEW_LINE);

        for (int col = BOARD_SIZE; col < PieceGroup.PIECE_LIST_MAX; col++) {
            sb.append(pieceList.get(col).getRepresentation());
        }

        return sb.toString();
    }
}
