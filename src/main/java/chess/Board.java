package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    public static final int MAX_PAWN = 8;

    private final List<Pawn> blackPawns = new ArrayList<>();
    private final List<Pawn> whitePawns = new ArrayList<>();

    public List<Pawn> blackPawns() {
        return Collections.unmodifiableList(blackPawns);
    }

    public List<Pawn> whitePawns() {
        return Collections.unmodifiableList(whitePawns);
    }

    public boolean addBlackPawn(Pawn pawn) {
        return blackPawns.add(pawn);
    }

    public boolean addWhitePawn(Pawn pawn) {
        return whitePawns.add(pawn);
    }

    public int size() { // 검은색 pawn과 흰색 pawn의 전체 개수를 반환한다.
        return blackPawns.size() + whitePawns.size();
    }

    public Pawn findBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public Pawn findWhitePawn(int index) {
        return whitePawns.get(index);
    }

    /* 흰색 pawn 8개, 검은색 pawn 8개를 생성해서 각각의 list에 추가한다. */
    public void initialize() {
        blackPawns.removeAll(blackPawns);  // initialize를 여러번 실행했을 때 pawn이 연속으로 추가되는 경우를 막는다.
        whitePawns.removeAll(whitePawns);

        for (int i = 0; i < Board.MAX_PAWN; i++) {
            addBlackPawn(Pawn.newBlackPawn());
            addWhitePawn(Pawn.newWhitePawn());
        }
    }

    /* 체스판의 결과를 StringBuilder에 저장한 후 String으로 반환한다. */
    public String print() {
        StringBuilder chessBoard = new StringBuilder();

        chessBoard.append("........\n")
                .append(getBlackPawnsResult() + "\n")
                .append("........\n")
                .append("........\n")
                .append("........\n")
                .append("........\n")
                .append(getWhitePawnsResult() + "\n")
                .append("........\n");

        return chessBoard.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder blackPawnRepresentations = new StringBuilder();

        for (Pawn black : blackPawns) {
            blackPawnRepresentations.append(black.getRepresentation());
        }

        return blackPawnRepresentations.toString();
    }

    public String getWhitePawnsResult() {
        StringBuilder whitePawnRepresentations = new StringBuilder();

        for (Pawn white : whitePawns) {
            whitePawnRepresentations.append(white.getRepresentation());
        }

        return whitePawnRepresentations.toString();
    }

}
