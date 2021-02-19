package cooper.chess;

import cooper.chess.piece.*;
import java.util.*;

import static cooper.chess.utils.StringUtils.*;

public class Board {
    private static final int PAWN_MAX_SIZE = 8;
    private static final String BLANK = "........";

    private final PawnGroup pawnGroup;

    public Board() {
        this.pawnGroup = new PawnGroup(createPawnGroup());
    }

    private Map<Color, List<Pawn>> createPawnGroup() {
        Map<Color, List<Pawn>> pawnListMap = new HashMap<>();
        pawnListMap.put(Color.WHITE, new ArrayList<>());
        pawnListMap.put(Color.BLACK, new ArrayList<>());

        return pawnListMap;
    }

    public void initialize() {
        initPawnList(Color.WHITE);
        initPawnList(Color.BLACK);
    }

    private List<Pawn> initPawnList(Color color) {
        List<Pawn> pawnList = pawnGroup.getPawnList(color);

        int pawnCount = 0;
        while(pawnCount++ < PAWN_MAX_SIZE) {
            pawnList.add(new Pawn(color.getColorName()));
        }

        return pawnList;
    }

    public void add(Pawn pawn) {
        List<Pawn> pawnList = pawnGroup.getPawnList(pawn.getColor());

        if(pawnList.size() >= 8) {
            return;
        }

        pawnList.add(pawn);
    }

    public int size(Color color) {
        return pawnGroup.getPawnList(color).size();
    }

    public Pawn findPawn(int index, Color color) {
        List<Pawn> pawnList = pawnGroup.getPawnList(color);

        if(pawnList.size() == 0) {
            throw new IllegalArgumentException("size가 0입니다.");
        }

        if ((0 > index) || (index >= pawnList.size())) {
            throw new IllegalArgumentException("범위를 벗어나는 인덱스 입니다.");
        }

        return pawnList.get(index);
    }

    public String getBoardStatus() {
        int index = 0;

        while(index < PAWN_MAX_SIZE) {
            appendNewLine(getEachRowStatus(index++));
        }

        return convertToString();
    }

    private String getEachRowStatus (int index) {
        if(index == PawnGroup.WHITE_INIT_INDEX) {
            return getPawnsResult(Color.WHITE);
        }

        if(index == PawnGroup.BLACK_INIT_INDEX) {
            return getPawnsResult(Color.BLACK);
        }

        return BLANK;
    }

    public String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        List<Pawn> pawnList = pawnGroup.getPawnList(color);

        for (int col = 0; col < PAWN_MAX_SIZE; col++) {
            sb.append(pawnList.get(col).getRepresentation());
        }

        return sb.toString();
    }
}
