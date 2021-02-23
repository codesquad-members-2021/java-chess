package net.kjk402.chess.pieces;

import net.kjk402.chess.pieces.Piece.*;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    private List<Piece> pieceList = new ArrayList<>();

    private void addPiece(Piece piece) {
        pieceList.add(piece);
    }

}
