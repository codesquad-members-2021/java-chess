package net.sky.chess;

import java.util.ArrayList;
import java.util.List;
import net.sky.pieces.Piece;

public class Rank {
    private List<Piece> rank = new ArrayList<>();

    public void add(Piece piece){
        rank.add(piece);
    }

    public List<Piece> getRank() {
        return rank;
    }
}
