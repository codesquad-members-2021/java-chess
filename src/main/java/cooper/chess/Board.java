package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    private static final int PAWN_MAX_SIZE = 8;
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
        initPawnList(Color.WHITE);
        initPawnList(Color.BLACK);
    }

    private List<Piece> initPawnList(Color color) {
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        int pawnCount = 0;
        while(pawnCount++ < PAWN_MAX_SIZE) {
            if(color == Color.WHITE) {
                pieceList.add(Piece.createWhitePawn());
            }

            if(color == Color.BLACK) {
                pieceList.add(Piece.createBlackPawn());
            }
        }

        return pieceList;
    }

    public void add(Piece piece) {
        List<Piece> pieceList = pieceGroup.getPawnList(piece.getColor());

        if(pieceList.size() >= 8) {
            return;
        }

        pieceList.add(piece);
    }

    public int size(Color color) {
        return pieceGroup.getPawnList(color).size();
    }

    public Piece findPawn(int index, Color color) {
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        if(pieceList.size() == 0) {
            throw new IllegalArgumentException("size가 0입니다.");
        }

        if ((0 > index) || (index >= pieceList.size())) {
            throw new IllegalArgumentException("범위를 벗어나는 인덱스 입니다.");
        }

        return pieceList.get(index);
    }

    public String getBoardStatus() {
        int index = 0;

        while(index < PAWN_MAX_SIZE) {
            appendNewLine(getEachRowStatus(index++));
        }

        return convertToString();
    }

    private String getEachRowStatus (int index) {
        if(index == PieceGroup.WHITE_PAWN_INIT_INDEX) {
            return getPawnsResult(Color.WHITE);
        }

        if(index == PieceGroup.BLACK_PAWN_INIT_INDEX) {
            return getPawnsResult(Color.BLACK);
        }

        return BLANK;
    }

    public String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Piece> pieceList = pieceGroup.getPawnList(color);

        for (int col = 0; col < PAWN_MAX_SIZE; col++) {
            sb.append(pieceList.get(col).getRepresentation());
        }

        return sb.toString();
    }
}
