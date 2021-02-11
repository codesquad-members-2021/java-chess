package net.honux.chess.core;

import net.honux.chess.entity.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private List<Pawn> pawnList = new ArrayList<>();

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public int size() {
        return pawnList.size();
    }

    public Optional<Pawn> findPawn(int index) {
        Optional<Pawn> pawn = Optional.empty();
        try {
            pawn = Optional.ofNullable(pawnList.get(index));
        }catch (IndexOutOfBoundsException e){
            System.out.println("해당 위치에 Pawn 이 존재하지 않습니다.");
        }
        return pawn;
    }

}
