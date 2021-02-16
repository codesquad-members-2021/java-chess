package chess;

import pieces.Color;
import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> whitePawns = new ArrayList<>();
    private final List<Pawn> blackPawns = new ArrayList<>();

    private final int BOARDSIZE = 8;

    private List<Row> board = new ArrayList<>(BOARDSIZE);

    public void addPawns(Pawn pawn) {
        if (pawn.getColorName() == Color.WHITE.getColorName()) {
            whitePawns.add(pawn);
        } else if (pawn.getColorName() == Color.BLACK.getColorName()) {
            blackPawns.add(pawn);
        } else {
            System.out.println("알 수 없는 color의 pawn입니다.");
            System.out.println("add에 실패하였습니다.");
        }
    }

    public int whitePawnSize() {
        return whitePawns.size();
    }

    public int blackPawnSize() {
        return blackPawns.size();
    }

    public Pawn getWhitePawn(int index) {
        return whitePawns.get(index);
    }

    public Pawn getBlackPawn(int index) {
        return blackPawns.get(index);
    }

    public String getWhitePawnsResult() {
        return getPawnsResult(Color.WHITE);
    }

    public String getBlackPawnsResult() {
        return getPawnsResult(Color.BLACK);
    }

    private String getPawnsResult(Color color) {
        StringBuilder sb = new StringBuilder();
        switch (color) {
            case WHITE:
                for (Pawn pawn : whitePawns) {
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();

            case BLACK:
                for (Pawn pawn : blackPawns) {
                    sb.append(pawn.getRepresentation());
                }
                return sb.toString();

            default:
                return "존재하지 않는 색상입니다.";
        }
    }

    public void initialize() {
        initPawn();

        final int blackPawnIndex = 1;
        final int whitePawnIndex = 6;
        for (int i = 0; i < BOARDSIZE; i++) {
            switch (i) {
                case blackPawnIndex:
                    board.add(new Row().initBlackPawns(this));
                    continue;
                case whitePawnIndex:
                    board.add(new Row().initWhitePawns(this));
                    continue;

                default:
                    board.add(new Row().initBlank());
            }
        }
    }

    private void initPawn() {
        for (int i = 0; i < BOARDSIZE; i++) {
            addPawns(new Pawn(Color.WHITE));
            addPawns(new Pawn(Color.BLACK));
        }
    }

    public String showBoard() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).getPicesSize(); j++) {
                sb.append(board.get(i).getPices(j));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
