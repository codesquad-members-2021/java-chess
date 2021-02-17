package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Pawn;

import java.util.*;

public class Board {
    private static final int PAWN_MAX_SIZE = 8;
    private static final int WHITE_INIT_INDEX = 1;
    private static final int BLACK_INIT_INDEX = 6;

    private final Map<Color, List<Pawn>> pawnListMap;

    public Board() {
        pawnListMap = new HashMap<>();
        pawnListMap.put(Color.WHITE, new ArrayList<>());
        pawnListMap.put(Color.BLACK, new ArrayList<>());
    }

    public void initialize() {
        initPawnList(Color.WHITE);
        initPawnList(Color.BLACK);
    }

    private void initPawnList(Color color) {
        List<Pawn> pawnList = pawnListMap.get(color);

        int pawnCount = 0;
        while(pawnCount++ < PAWN_MAX_SIZE) {
            pawnList.add(new Pawn(color.getColorName()));
        }
    }

    public void add(Pawn pawn) {
        List<Pawn> pawnList = pawnListMap.get(pawn.getColor());
        pawnList.add(pawn);
    }

    public int size(Color color) {
        return pawnListMap.get(color).size();
    }

    public Pawn findPawn(int index, Color color) {
        List<Pawn> pawnList = pawnListMap.get(color);

        if(pawnList.size() == 0) {
            throw new IllegalArgumentException("size가 0입니다.");
        }

        if ((0 > index) || (index >= pawnList.size())) {
            throw new IllegalArgumentException("범위를 벗어나는 인덱스 입니다.");
        }

        return pawnList.get(index);
    }

    public String getBoardStatus() {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while(index < PAWN_MAX_SIZE) {
            sb.append(getEachRowStatus(index++)).append("\n");
        }

        return sb.toString();
    }

    private String getEachRowStatus (int index) {
        StringBuilder sb = new StringBuilder();

        if(index == WHITE_INIT_INDEX) {
            return getPawnsResult(Color.WHITE);
        }

        if(index == BLACK_INIT_INDEX) {
            return getPawnsResult(Color.BLACK);
        }

        return getBlank(sb);
    }

    public String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Pawn> pawnList = pawnListMap.get(color);

        for (int col = 0; col < PAWN_MAX_SIZE; col++) {
            sb.append(pawnList.get(col).getRepresentation());
        }

        return sb.toString();
    }

    private String getBlank(StringBuilder sb) {
        for (int i = 0; i < PAWN_MAX_SIZE; i++) {
            sb.append('.');
        }

        return sb.toString();
    }
}
