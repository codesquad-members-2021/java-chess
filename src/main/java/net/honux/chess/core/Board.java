package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.entity.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private static final int BOARD_SIZE = 8;
    private List<Pawn> whitePawnList;
    private List<Pawn> blackPawnList;

    public void initialize() {
        whitePawnList = new ArrayList<>();
        blackPawnList = new ArrayList<>();

        for (int i = 0; i < BOARD_SIZE; i++) {
            whitePawnList.add(new Pawn(Color.WHITE));
            blackPawnList.add(new Pawn(Color.BLACK));
        }
    }

    public void add(Pawn pawn) {
        if (pawn.getColor() == Color.BLACK) {
            blackPawnList.add(pawn);
        } else {
            whitePawnList.add(pawn);
        }
    }

    public int whitePawnsize() {
        return whitePawnList.size();
    }

    public int blackPawnsize() {
        return blackPawnList.size();
    }

    public Optional<Pawn> findWhitePawn(int index) {
        Optional<Pawn> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(whitePawnList.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("해당 위치에 Pawn 이 존재하지 않습니다.");
        }
        return pawn;
    }

    public Optional<Pawn> findBlackPawn(int index) {
        Optional<Pawn> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(blackPawnList.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("해당 위치에 Pawn 이 존재하지 않습니다.");
        }
        return pawn;
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : whitePawnList) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn pawn : blackPawnList) {
            sb.append(pawn.getRepresentation());
        }
        return sb.toString();
    }

}
